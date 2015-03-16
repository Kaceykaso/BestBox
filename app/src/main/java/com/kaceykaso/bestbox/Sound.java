package com.kaceykaso.bestbox;

/**
 * Created by kcoughli on 3/6/15.
 */
public class Sound {

    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    // Sound object
    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        // Check for different file types
        if (filename.contains(".wav")) {
            mName = filename.replace(".wav", "");
        } else if (filename.contains(".aiff")) {
            mName = filename.replace(".aiff", "");
        } else if (filename.contains(".mp3")) {
            mName = filename.replace(".mp3", "");
        }
    }


    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

    // Add ID's for sounds
    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
