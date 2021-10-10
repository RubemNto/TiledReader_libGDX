package com.mygdx.tiledmapreader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tileset {
    private int firstgid;
    private String source;
    private Texture tileset;

    public void SetSource() {
        String[] tempSource = source.split("/");
        String[] fileName = tempSource[tempSource.length - 1].split("\\.");
        source = "Tilesets/" + fileName[0] + ".png";
    }

    public void dispose()
    {
        tileset.dispose();
    }

    public int getFirstgid()
    {
        return firstgid;
    }

    public void SetTileset()
    {
        tileset = new Texture(source);
    }

    public Texture getTileset()
    {
        return tileset;
    }
}
