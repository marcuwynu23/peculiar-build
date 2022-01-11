
package com.peculiar.components;

/**
 *
 * @author admin
 */
public class AppHover  extends java.awt.event.MouseAdapter{
	private java.awt.Component comp;
	private java.awt.Color c1, c2;

	private AppHover(java.awt.Component comp,java.awt.Color c1, java.awt.Color c2){
		this.comp = comp;
		this.c1 = c1;
		this.c2 = c2;
	}
	public void mouseExited(java.awt.event.MouseEvent ev){
		comp.setBackground(c1);
		comp.setForeground(c2);
	}
	public void mouseEntered(java.awt.event.MouseEvent ev){
		comp.setBackground(c2);
		comp.setForeground(c1);
	}
	public static synchronized AppHover getInstance(final java.awt.Component comp, final java.awt.Color c1, final java.awt.Color c2){
		return new AppHover(comp,c1,c2);
	}
}