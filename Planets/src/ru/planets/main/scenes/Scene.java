package ru.planets.main.scenes;

import java.awt.Graphics;

public abstract class Scene {
	abstract public void Render(Graphics g);
	abstract public void Update(double delta);
}
