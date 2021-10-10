package com.mygdx.tiledmapreader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;
import java.util.Objects;

public class TiledWorld {
    private ArrayList<TileLayer> tilesLayers;
    private ArrayList<ImageLayer> imageLayers;
    private ArrayList<Tileset> tilesets;
    private int tileWidth,tileHeight;

    public int getTiledWidth() {return tileWidth;}
    public int getTiledHeight() {return tileHeight;}

    public TiledWorld(String TiledWorldJsonPath) {
        tilesLayers = new ArrayList<TileLayer>();
        imageLayers = new ArrayList<ImageLayer>();
        tilesets = new ArrayList<Tileset>();
        Json json = new Json();
        JsonReader jsonReader = new JsonReader();

        FileHandle jsonFile = Gdx.files.internal("JsonFiles/TestWorldLibGdxReader.json");
        JsonValue jsonValue = jsonReader.parse(jsonFile);

        JsonValue tileheightData = jsonValue.get("tileheight");
        tileHeight = tileheightData.asInt();
        JsonValue tilewidthData = jsonValue.get("tilewidth");
        tileWidth = tilewidthData.asInt();

        JsonValue layers = jsonValue.getChild("layers");
        while (layers != null) {
            String tempJson = "{\n";
            for (JsonValue j : layers) {
                tempJson = tempJson + j.toString() + ",\n";
            }
            tempJson += "}";

            JsonValue type = layers.get("type");
            if (Objects.equals(type.toString(), "type: imagelayer")) {
                ImageLayer newImageLayer = json.fromJson(ImageLayer.class, tempJson);
                newImageLayer.SetBackgroundImage();
                imageLayers.add(newImageLayer);
            } else if (Objects.equals(type.toString(), "type: tilelayer")) {
                TileLayer newTileLayer = json.fromJson(TileLayer.class, tempJson);
                tilesLayers.add(newTileLayer);
            }
            layers = layers.next;
        }

        JsonValue tilesetsJson = jsonValue.getChild("tilesets");
        while (tilesetsJson != null) {
            String tempJson = "{\n";
            for (JsonValue j : tilesetsJson) {
                tempJson = tempJson + j.toString() + ",\n";
            }
            tempJson += "}";
            Tileset newTileset = json.fromJson(Tileset.class, tempJson);
            newTileset.SetSource();
            newTileset.SetTileset();
            tilesets.add(newTileset);
            tilesetsJson = tilesetsJson.next;
        }
    }

    public void Draw(SpriteBatch spriteBatch) {
        for (ImageLayer img: imageLayers) {
            img.Draw(spriteBatch,1);
        }
        for (TileLayer tile: tilesLayers) {
            tile.Draw(spriteBatch,tilesets,16,16,1);
        }
    }

    public void Draw(SpriteBatch spriteBatch,float scaler) {
        for (ImageLayer img: imageLayers) {
            img.Draw(spriteBatch,scaler);
        }

        for (TileLayer tile: tilesLayers) {
            tile.Draw(spriteBatch,tilesets,16,16,scaler);
        }
    }

    public void dispose()
    {
        for (Tileset tileset:tilesets
             ) {
            tileset.dispose();
        }
    }

}
