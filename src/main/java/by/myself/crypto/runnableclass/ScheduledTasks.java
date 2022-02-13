package by.myself.crypto.runnableclass;

import by.myself.crypto.CryptoApplication;
import by.myself.crypto.entity.Crypto;
import by.myself.crypto.entity.Track;
import by.myself.crypto.service.impl.ICryptoService;
import by.myself.crypto.service.impl.ITrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ScheduledTasks {
    static final Logger logger = LoggerFactory.getLogger(CryptoApplication.class);

    @Autowired
    private ICryptoService cryptoService;

    @Autowired
    private ITrackService trackService;

    @Scheduled(fixedRate = 60000)
    public void getFromServer() {
        int[] listOfCryptos = {80, 90, 48543};

        for (int indexOfCrypto : listOfCryptos) {
            getAndSaveToServer(indexOfCrypto);
        }
        checkTracking();
    }

    public void getAndSaveToServer(int id) {
        CommunicationWithCoinLore communicationWithCoinLore = new CommunicationWithCoinLore();
        Crypto cry = communicationWithCoinLore.findById(id);
        cryptoService.save(cry);
    }

    public void checkTracking() {
        List<Track> trackList = trackService.findAll();
        if (!trackList.isEmpty()) {
            List<Crypto> cryptoList = cryptoService.findAll();
            for (Crypto crypto : cryptoList) {
                for (Track track : trackList) {
                    if (Objects.equals(track.getSymbol_cr(), crypto.getSymbol())) {
                        double price_usd = Double.parseDouble(crypto.getPrice_usd());
                        double change = price_usd / track.getPrice_usd();
                        if (change <= 0.99 && change >= 1.01) {
                            logger.warn(track.getSymbol_cr() + " " + track.getUsername() + " " + change);
                        }
                    }
                }
            }
        }
    }
}
