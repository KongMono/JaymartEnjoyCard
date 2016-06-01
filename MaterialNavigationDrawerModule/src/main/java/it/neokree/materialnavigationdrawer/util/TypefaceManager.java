package it.neokree.materialnavigationdrawer.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;

/**
 * Custom Typeface Manager for Roboto Fonts inside the drawer
 *
 * Created by neokree on 13/01/15.
 */
public class TypefaceManager {
    private static final String TBOLD ="TBold.ttf";
    private static final String TLIGHT = "TLight.ttf";
    private static final String TMEDIUM = "TMedium.ttf";
    private final LruCache<String, Typeface> mCache;
    private final AssetManager mAssetManager;

    public TypefaceManager(AssetManager assetManager) {
        mAssetManager = assetManager;
        mCache = new LruCache<>(3);
    }
    public Typeface getTBold() {
        return getTypeface(TBOLD);
    }

    public Typeface getTLight() {
        return getTypeface(TLIGHT);
    }

    public Typeface getTMdium() {
        return getTypeface(TMEDIUM);
    }

    private Typeface getTypeface(final String filename) {
        Typeface typeface = mCache.get(filename);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(mAssetManager, "fonts/" + filename);
            mCache.put(filename, typeface);
        }
        return typeface;
    }
}
