package com.gas.switcher;

import com.badlogic.gdx.audio.Sound;
import com.gas.switcher.management.Prefs;
import com.gas.switcher.management.SceneManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gas.switcher.scenes.Board;
import com.gas.switcher.utils.AssetPaths;
import com.gas.switcher.utils.Levels;

public class Switcher extends Game {

	public SceneManager sceneManager;
	public AssetManager assetManager;
	public SpriteBatch batch;
	public Prefs prefs;
	private Sound click;


	public static int SCALE_WIDTH = 1080;
	public static int SCALE_HEIGHT = 1920;
	public int scaleFactorX;
	public int scaleFactorY;

	public static int FPS = 60;

	private boolean soundEffectsOn = true;

	private int level;


	@Override
	public void create () {
		click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));

		if(Gdx.graphics.getHeight()<Gdx.graphics.getWidth()){
			scaleFactorX = Gdx.graphics.getWidth()/SCALE_WIDTH;
			scaleFactorY = Gdx.graphics.getHeight()/SCALE_HEIGHT;
		} else{
			scaleFactorX = Gdx.graphics.getHeight()/SCALE_WIDTH;
			scaleFactorY = Gdx.graphics.getWidth()/SCALE_HEIGHT;
		}
		batch = new SpriteBatch();
		assetManager = new AssetManager();
		loadAssets();
		sceneManager = new SceneManager(this);
		prefs = new Prefs();
		Levels.initLevels();

	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		assetManager.dispose();
		sceneManager.dispose();
	}

	private void loadAssets(){
		assetManager.load(AssetPaths.BACKGROUND, Texture.class);
		assetManager.load(AssetPaths.BUTTON, Texture.class);
		assetManager.load(AssetPaths.SHADOW_OUT, Texture.class);
		assetManager.load(AssetPaths.SHADOW_IN, Texture.class);
		assetManager.load(AssetPaths.BUTTON_SHADOWGATE, Texture.class);
		assetManager.load(AssetPaths.BUTTON_CIRCLE, Texture.class);
		assetManager.load(AssetPaths.BUTTON_CHECK, Texture.class);
		assetManager.load(AssetPaths.BUTTON_BACK, Texture.class);
		assetManager.load(AssetPaths.BUTTON_FIVE, Texture.class);
		assetManager.load(AssetPaths.BUTTON_NINE, Texture.class);
		assetManager.load(AssetPaths.BUTTON_SANDWICH, Texture.class);
		assetManager.load(AssetPaths.BUTTON_RETRY, Texture.class);
		assetManager.load(AssetPaths.BUTTON_SOUND, Texture.class);

		assetManager.finishLoading();
	}

	public boolean isSoundEffectsOn() {
		return soundEffectsOn;
	}

	public void setSoundEffectsOn(boolean soundEffectsOn) {
		this.soundEffectsOn = soundEffectsOn;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Sound getClick(){
		return click;
	}
}