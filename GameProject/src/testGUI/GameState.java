package testGUI;

import java.awt.Graphics;

import testGUI.entities.creatures.Player;
import testGUI.entities.statics.House;
import testGUI.worlds.World;

public class GameState extends State{


	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);


	}
	
	@Override
	public void tick() {
		world.tick();

	}

	@Override
	public void render(Graphics g) {
		world.render(g);

	}

	
	
}
