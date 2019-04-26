package aiss.model.repository;

public class MapFooDreamsRepository {
	
//	Map<String, Playlist> playlistMap;
//	Map<String, Song> songMap;
	private static MapFooDreamsRepository instance=null;
//	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapFooDreamsRepository getInstance() {
		
		if (instance==null) {
			instance = new MapFooDreamsRepository();
//			instance.init();
		}
		
		return instance;
	}

}
