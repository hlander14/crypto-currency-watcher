package by.myself.crypto.repository;

import by.myself.crypto.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, String> {
}
