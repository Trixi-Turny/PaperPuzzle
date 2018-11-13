package com.oddschecker.paperpuzzle;


/**
 * Facilitates different types of files according to their mime types
 */
public enum FileType {


    CSV("text/csv"), PDF("application/pdf"), TXT("text/plain");


    private String mimeType;
    FileType(String mimeType) {
        this.mimeType = mimeType;
    }
}
