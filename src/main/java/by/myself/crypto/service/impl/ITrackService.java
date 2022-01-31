package by.myself.crypto.service.impl;

import by.myself.crypto.entity.Track;
import by.myself.crypto.exception_handling.NoSuchCryptoException;
import by.myself.crypto.repository.TrackRepository;
import by.myself.crypto.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ITrackService implements TrackService<Track, Integer> {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track findById(Integer id) {
        Optional<Track> optionalTrack = trackRepository.findById(id);
        if (optionalTrack.isEmpty()) {
            throw new NoSuchCryptoException("There is no crypto with ID = " + id + " in database");
        }
        return optionalTrack.get();
    }

    @Override
    public void save(Track entity) {
        trackRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        trackRepository.deleteById(id);
    }
}