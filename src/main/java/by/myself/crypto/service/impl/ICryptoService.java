package by.myself.crypto.service.impl;

import by.myself.crypto.entity.Crypto;
import by.myself.crypto.exception_handling.NoSuchCryptoException;
import by.myself.crypto.repository.CryptoRepository;
import by.myself.crypto.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICryptoService implements CryptoService<Crypto, String> {

    @Autowired
    private CryptoRepository cryptoRepository;

    @Override
    public List<Crypto> findAll() {
        return cryptoRepository.findAll();
    }

    @Override
    public Crypto findById(String id) {
        Optional<Crypto> optionalCrypto = cryptoRepository.findById(id);
        if (optionalCrypto.isEmpty()) {
            throw new NoSuchCryptoException("There is no crypto with ID = " + id + " in database");
        }
        return optionalCrypto.get();
    }

    @Override
    public void save(Crypto entity) {
        cryptoRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        cryptoRepository.deleteById(id);
    }
}
