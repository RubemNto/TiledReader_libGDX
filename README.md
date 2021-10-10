# TiledReader_libGDX
<p align="center">
<img src="https://dashboard.snapcraft.io/site_media/appmedia/2018/03/tiled-logo-256.png" width="200">
<img src="https://www.pinclipart.com/picdir/big/528-5284520_hand-png-icon-shaking-hands-logo-png-clipart.png" width="150">
<img src = "https://blackcaviar.games/images/tild6462-3432-4639-b963-333230333438__photo.png" width="200">
</p>

# How To Use
1. Create new TiledWorld variable and make an instance of it inside **create**. It should be added as a parameter the path to the tiled json file in the project.

        public TiledWorld tiledWorld;
        @Override
            public void create () 
            {
                batch = new SpriteBatch();
                tiledWorld = new TiledWorld("JsonFiles/TestWorldLibGdxReader.json");
                camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
                camera.translate(Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f);
            }
2. Inside assets folder, create 3 new folders for the files needed for the development of the project named **Images**,**JsonFiles** and **Tilesets**. Last, you should create inside Images a new folder called **Backgrounds**.
3. Last, in the render function, between batch.begin and batch.end, add the draw function and adjust the scale based on what your project will show on the screen.

        @Override
        public void render () {
            batch.begin();
            tiledWorld.Draw(batch,5f);
            batch.end();
        }

<p align="center">Feel free to use this in any of your personal and comercial projects, but recognition is very much appreciated.
<br>
<br>
If you liked my work and want to see more, follow my <a href="https://github.com/RubemNto">GitHub</a>, and social media profiles. Other than that, remember:
<br>
<h2 align="center">Just Keep Coding</h2>
    <p align="center">Instagram: <a href="https://www.instagram.com/dev_rubs/">@dev_rubs</a>
    <br>
    Twitter: <a href="https://twitter.com/ChristRubem">@ChristRubem</a>
</p>

