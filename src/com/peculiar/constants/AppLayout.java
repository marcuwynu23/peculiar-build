/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peculiar.constants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

/**
 *
 * @author admin
 */
public final class AppLayout {
    public static final LayoutManager GRIDBAG = new GridBagLayout();
    public static final LayoutManager BORDER = new BorderLayout();
    public static final LayoutManager NULL = null;
    public static final LayoutManager FLOW_RIGHT = new FlowLayout(FlowLayout.RIGHT);
    public static final LayoutManager FLOW_LEFT = new FlowLayout(FlowLayout.LEFT);
    public static final LayoutManager FLOW_CENTER = new FlowLayout(FlowLayout.CENTER);
    public static final String BORDER_NORTH = BorderLayout.NORTH;
    public static final String BORDER_SOUTH = BorderLayout.SOUTH;
    public static final String BORDER_EAST = BorderLayout.EAST;
    public static final String BORDER_WEST = BorderLayout.WEST;
    public static final String BORDER_CENTER = BorderLayout.CENTER;

}
