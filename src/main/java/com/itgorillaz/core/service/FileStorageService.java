package com.itgorillaz.core.service;

import java.util.Optional;

public interface FileStorageService {

	boolean exists(String dir, String file);
	
	Optional<FileDetails> getFileDetails(String dir, String file);
	
	Optional<String> getFileContents(String dir, String file);
	
}
