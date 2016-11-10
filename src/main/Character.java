/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Casa
 */
public class Character extends Base{
    
    public int ID;
    public int maxHp;
    public int hp;
    public int speed;
    public int dir;
    public int iTipo;
    public Boolean isPlayable;
    public Boolean bMovMalo;
    public LinkedList inventory;
    public Boolean isAlive;
    public Animacion aniAnimacion;
        
    public Character(int x, int y, Image img, Animacion ani ,int id, int maxhp, int hp, 
            int speed, int dir, Boolean isplayable, LinkedList invent, 
            Boolean isalive) {
        super(x, y, img);
        ID = id;
        aniAnimacion = ani;
        maxHp = maxhp;
        this.hp = hp;
        this.speed = speed;
        this.dir = dir;
        isPlayable = isplayable;
        inventory = invent;
        isAlive = isalive;
    }
    public int getAncho() {
        return (new ImageIcon(this.getAnimacion().getImagen()).getIconWidth());
    }

    public int getAlto() {
        return (new ImageIcon(this.getAnimacion().getImagen()).getIconHeight());
    }
    public boolean getMov(){
        return bMovMalo;
    }
    public int getId() {
        return ID;
    }
    
    public int getTipo() {
        return iTipo;
    }
    
    
    public int getMaxHp() {
        return maxHp;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public int getDir() {
        return dir;
    }
    
    public Boolean getIsPlayable() {
       return isPlayable;
    }
    
    public LinkedList getInventory() {
        return inventory;
    }
    
    public Boolean getIsAlive() {
         return isAlive;
    }
    
    public void setId(int id) {
        ID = id;
    }
    
    public void setMaxHp(int max) {
        maxHp = max;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void setMov(boolean b){
        this.bMovMalo = b;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void setDir(int dir) {
        this.dir = dir;
    }
    
    public void setIsPlayable(Boolean isP) {
        isPlayable = isP;
    }
    
    public void setInventory(LinkedList inv) {
        inventory = inv;
    }
    
    public void setTipo(int i) {
        iTipo = i;
    }
    
    public void setIsAlive(Boolean isalive) {
        isAlive = isalive;
    }
    
    public void setAnimacion(Animacion ani) {
        aniAnimacion = ani;
    }
    
    public Animacion getAnimacion() {
        return aniAnimacion;
    }
    public boolean colisiona(Character aniParametro) {
        // creo un objeto rectangulo a partir de este objeto Autos
        Rectangle recObjeto = new Rectangle(this.getX(),this.getY(),
                this.getAncho(), this.getAlto());
        // creo un objeto rectangulo a partir del objeto Autos parametro
        Rectangle recParametro = new Rectangle(aniParametro.getX(),
                aniParametro.getY(), aniParametro.getAncho(),
                aniParametro.getAlto());
        
        // si se colisionan regreso verdadero, sino regreso falso
        return recObjeto.intersects(recParametro);
    }
    
 }
