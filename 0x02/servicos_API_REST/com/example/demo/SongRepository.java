import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public SongRepository() {
        this.list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
        this.list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
    }

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        list.stream()
                .filter(song -> song.getId().equals(s.getId()))
                .findFirst()
                .ifPresent(song -> {
                    song.setNome(s.getNome());
                    song.setArtista(s.getArtista());
                    song.setAlbum(s.getAlbum());
                    song.setAnoLancamento(s.getAnoLancamento());
                });
    }

    public void removeSong(Song s) {
        list.removeIf(song -> song.getId().equals(s.getId()));
    }
}
