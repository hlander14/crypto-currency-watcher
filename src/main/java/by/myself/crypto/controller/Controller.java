package by.myself.crypto.controller;

import by.myself.crypto.entity.Crypto;
import by.myself.crypto.entity.Track;
import by.myself.crypto.service.impl.ICryptoService;
import by.myself.crypto.service.impl.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ICryptoService cryptoService;

    @Autowired
    private ITrackService trackService;

    @GetMapping("/cryptos")
    public List<Crypto> findAll() {
        return cryptoService.findAll();
    }

    @GetMapping("/cryptos/available")
    public List<String> showAvailable() {
        List<Crypto> listCrypto = cryptoService.findAll();
        List<String> listAvailableCrypto = new ArrayList<>();
        for (Crypto crypto : listCrypto) {
            listAvailableCrypto.add(crypto.getSymbol());
        }
        return listAvailableCrypto;
    }

    @GetMapping("/cryptos/{id}")
    public Double findById(@PathVariable("id") String id) {
        return Double.parseDouble(cryptoService.findById(id).getPrice_usd());
    }

    @GetMapping("/cryptos/notify/{user}/{symbol_cr}")
    public String notify(@PathVariable("user") String user,
                               @PathVariable("symbol_cr") String symbol_cr){
        Track singleTrack;
        List<Track> trackList = trackService.findAll();

        boolean flag = true;
        if (!trackList.isEmpty()) {
            for (Track track : trackList) {
                System.out.println(track.getUsername() + " !! " + track.getSymbol_cr());
                if (Objects.equals(track.getUsername(), user) && Objects.equals(track.getSymbol_cr(), symbol_cr)) {
                    flag = false;
                    break;
                }
            }
        }

        double price = 0.0;
        if (flag) {
            List<Crypto> cryptoList = cryptoService.findAll();
            for (Crypto crypto : cryptoList) {
                if (Objects.equals(crypto.getSymbol(), symbol_cr)) {
                    price = Double.parseDouble(crypto.getPrice_usd());
                }
            }

            singleTrack = new Track(user, symbol_cr, price, LocalDateTime.now());
            trackService.save(singleTrack);
        } else {
            return "That USER and SYMBOL always exist";
        }
        return "USER and SYMBOL was registered";
    }
}
