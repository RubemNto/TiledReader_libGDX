package com.mygdx.tiledmapreader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageLayer {
    private String type;
    private String name;
    private String image;

    private int id;
    private int opacity;
    private int x,y;
    private boolean visible;

    private Texture backgroundImage;

    public void SetBackgroundImage()
    {
        String[] tempImage = image.split("/");
        image = "Images/Backgrounds/"+tempImage[tempImage.length-1];
        backgroundImage = new Texture(image);
    }

    public void Draw(SpriteBatch spriteBatch,float scaler)
    {
        spriteBatch.draw(
                backgroundImage,
                0,
                0,
                backgroundImage.getWidth()*scaler,
                backgroundImage.getHeight()*scaler
        );
    }
}
