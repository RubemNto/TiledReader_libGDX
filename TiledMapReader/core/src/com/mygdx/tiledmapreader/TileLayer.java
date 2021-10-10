package com.mygdx.tiledmapreader;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class TileLayer {
    private int[] data;
    private String name;
    private String type;

    private int height;
    private int width;
    private int id;
    private int opacity;
    private int x, y;
    private boolean visible;

    public void Draw(SpriteBatch spriteBatch, ArrayList<Tileset> tilesets, int tileWidth, int tileHeight,float scale) {
        Vector2 drawPos = new Vector2(0f, height*tileHeight-tileHeight);
        for (int i : data) {
            if (i != 0) {
                for (Tileset tileset : tilesets) {
                    int tilesetArea;
                    tilesetArea = tileset.getTileset().getWidth() / tileWidth * tileset.getTileset().getHeight() / tileHeight;
                    tilesetArea += (tileset.getFirstgid() - 1);
                    if (tileset.getFirstgid() <= i && i <= tilesetArea) {
                        Vector2 interiorImagePos = new Vector2(0f, 0f);
                        for (int imageOffset = tileset.getFirstgid(); imageOffset < i; imageOffset++) {
                            if (interiorImagePos.x >= tileset.getTileset().getWidth()-tileWidth) {
                                interiorImagePos = new Vector2(0, interiorImagePos.y + tileHeight);
                            } else {
                                interiorImagePos = new Vector2(interiorImagePos.x + tileWidth, interiorImagePos.y);
                            }
                        }
                        spriteBatch.draw(
                                tileset.getTileset(),
                                drawPos.x*scale,
                                drawPos.y*scale,
                                0,0,
                                tileWidth,
                                tileHeight,
                                scale,scale,0,
                                (int) interiorImagePos.x ,
                                (int) interiorImagePos.y,
                                tileWidth,
                                tileHeight,
                                false,
                                false
                        );
                        break;
                    }
                }
            }
            if (drawPos.x >= width * tileWidth-tileWidth) {
                drawPos = new Vector2(0, drawPos.y - tileHeight);
            } else {
                drawPos = new Vector2(drawPos.x + tileWidth, drawPos.y);
            }
        }
    }
}
