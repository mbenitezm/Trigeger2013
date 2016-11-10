/*
Trigger
Marcel Benítez 1139855
Hugo Gonzalez Pinelo 1191470
Jerónimo Martínez 1191487
Estefanía Guajardo 813202
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author Casa
 */
public class Trigger extends JFrame implements Runnable, KeyListener
        , MouseListener {

    private Graphics graGraficaApplet;  // Objeto grafico de la Imagen
    private Animacion aniMovF;          // Movimiento del personaje principal F
    private Animacion aniMovI;          // Anuimacion de movimionte izquierda
    private Animacion aniMovD;          // Animacion de movimiento derecha
    private Animacion aniMovA;          // Animacion de movimiento hacia arriba
    private Animacion aniMovFE;          // Movimiento del personaje principal F
    private Animacion aniMovIE;          // Anuimacion de movimionte izquierda
    private Animacion aniMovDE;          // Animacion de movimiento derecha
    private Animacion aniMovAE;          // Animacion de movimiento hacia arriba
    private Animacion aniAtaD;          // Animacion de ataque hacia la derecha
    private Animacion aniAtaI;          // Animacion de ataque hacia la izq.
    private Animacion aniAtaF;          // Animacion de ataque hacia el frente
    private Animacion aniAtaA;          // Animacion de ataque hacia arriba
    private Animacion aniMovFMalo;  // Movimiento del personaje principal F del malo
    private Animacion aniMovIMalo;          // Anuimacion de movimionte izquierda del malo
    private Animacion aniMovDMalo;          // Animacion de movimiento derecha del malo
    private Animacion aniMovAMalo;          // Animacion de movimiento hacia arriba del malo
    private Animacion aniAtaDMalo;          // Animacion de ataque hacia la derecha
    private Animacion aniAtaIMalo;          // Animacion de ataque hacia la izq.
    private Animacion aniAtaFMalo;          // Animacion de ataque hacia el frente
    private Animacion aniAtaAMalo;          // Animacion de ataque hacia arriba
    private Animacion aniMovFMalo2;          // Movimiento del personaje principal F del malo 2
    private Animacion aniMovIMalo2;          // Anuimacion de movimionte izquierda del malo 2
    private Animacion aniMovDMalo2;          // Animacion de movimiento derecha del malo 2
    private Animacion aniMovAMalo2;          // Animacion de movimiento hacia arriba del malo 2
    private Animacion aniAtaDMalo2;          // Animacion de ataque hacia la derecha del malo 2
    private Animacion aniAtaIMalo2;          // Animacion de ataque hacia la izq. del malo 2
    private Animacion aniAtaFMalo2;          // Animacion de ataque hacia el frente del malo 2
    private Animacion aniAtaAMalo2;          // Animacion de ataque hacia arriba del malo 2
    private Animacion aniAtaDJefe;          // Animacion de ataque hacia la derecha jefe
    private Animacion aniAtaIJefe;          // Animacion de ataque hacia la izq jefe
    private Animacion aniAtaFJefe;          // Animacion de ataque hacia el frente jefe
    private Animacion aniAtaAJefe;          // Animacion de ataque hacia arriba jefe
    private Animacion aniMovFJefe;          // Movimiento del personaje principal F del jefe
    private Animacion aniMovIJefe;          // Anuimacion de movimionte izquierda del jefe
    private Animacion aniMovDJefe;          // Animacion de movimiento derecha del jefe
    private Animacion aniMovAJefe;          // Animacion de movimiento hacia arriba deljefe
    private Animacion aniNpc1;          //animacion del npc1
    private Animacion aniMuerte;        // Animacion de muerte de malos
    private Character charPersonaje;    // Personaje principal
    private long tiempoActual;          // Tiempo actual del sistema global
    private boolean bMovimiento;        // Booleana si se esta en movimiento
    private boolean bAtaque;            // Booleana si se esta atacando
    private boolean bAtaqueMalo;            // Booleana si se esta atacando
    private boolean bMovimientoMalo;        // Booleana si se esta en movimiento
    private boolean bMenu;          //el menu se despliege si el boolean es true
    private boolean bLab;           //este boolean indica si estas en el labo
    private boolean bMensaje1;         // booleana paramostrar mensaje 1
    private boolean bFisica1;           // Mensaje 1 de fisica
    private boolean bCargar;        // Variable para estado de menu
    private boolean bGuardar;       // Variable para estado del menu
    private boolean bInstrucciones; // Variable para estado del menu
    private boolean bExit;          // Variable para estado del menu
    private boolean bMostrarI;      // si se mustra las instrucciones
    private boolean bInicio;        // Si ya se inicio el juego
    private boolean bVictoria;      // Si se gano el juego
    private boolean bPerder;        // Si ya perdio
    private Image imaImagenApplet;   // Imagen a proyectar en Applet
    private int cantTiles;              //variable temportal, destruir
    private int iContAni;           // Contador para animacion de ataque
    private int iContAniMalo;        // Contador par aanimacion de ataque de malo
    private int iContAniMuerte;  // Contador de animacion de muertes
    private int idPersonajes;       //cada personaje tiene una identifiacion
    private int idNpc;              // Identificador de npc
    private int iContFisica;
    private int iContadorMov;       //los enemigos se tienen que mover por un eje
    private int distanciaAtaqueX;    //la distancia en la que los ataques son efectivos en eje X
    private int distanciaAtaqueY;   //distancia en eje Y
    private int distanciaEneAtaqueX;//distancia eje X apra enemigos
    private int distanciaEneAtaqueY;//distancia eje Y para enemigos
    private int contadorAtaqueMain; //para que el jugador no solo le pique a spacebar
    private int distanciaProxPrin;     //distancia que se puede acercar a paredes
    private int distanciaProxSec;     //distancia que se puede acercar a paredes
    private int distanciaEmpujonChar;   //que tan lejos empuja el jugador
    private int distanciaEmpujonEne;    // que tan lejos empuja el enemigo
    private int iImpactX;               // Impacto en x de ataque
    private int iImpactY;           // Impacto en y de ataque
    private int idJefe;             //saber que id es la del jefe
    private int iContPots;
                                    //cierta cantidad de tiempo antes de moverse en el otro
    private long tiempoDAtaque;     //para que los enemigos no te ataquen cada milisegundo
    LinkedList map;                     //mapa del juego
    private String nombreArchivoMapa;          //nombre del mapa para cargar
    private LinkedList arrPersonajes;   //Arreglo con jugadores
    private LinkedList arrEnemigos;     //Arreglo con monstruos
    private LinkedList arrCementerio; // Arreglo con mounstros muertos
    private LinkedList arrNpcs;         //Arreglo con npcs
    // Imagenes de barra de vida
    private Image imaVida0;
    private Image imaVida25;
    private Image imaVida50;
    private Image imaVida75;
    private Image imaVida100;
    private Image imaPotion;
    private Image imaMenu1;
    private Image imaMenu2;
    private Image imaMenu3;
    private Image imaMenu4;
    private Image imaMenu5;
    private SoundClip soundInicio; // Sonido 1
    private SoundClip soundAtaque; // Sonido 2
    private SoundClip soundBack;
    private URL urlG;
    

    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Se inicializan variables en falso y contador en 0
        bInicio = false;
        bMostrarI = false;
        bMovimiento = false;
        bAtaque = false;
        bAtaqueMalo = false;
        bVictoria = false;
        iContAniMuerte = 0;
        bMovimientoMalo = true;
        this.setSize(1000,1000);
        iContAni = 0;
        iContAniMalo = 0;
        bMenu = true;      //por defecto el menu no se despliega
        tiempoDAtaque = 0;
        contadorAtaqueMain = 0;
        arrNpcs = new LinkedList();
        iContFisica = 0;
        bFisica1 = false;
        distanciaProxPrin = 80;
        distanciaProxSec = 60;
        iContPots = 3;
        bCargar = true;
        bGuardar = false;
        bInstrucciones = false;
        bExit = false;
        bPerder = false;

        distanciaEmpujonChar = 160;
        distanciaEmpujonEne = 70;

        idPersonajes = 0;   //por defecto el contador empieza en 0
        idNpc = 0;

        map = new LinkedList();     //el mapa se hace aqui
        try {
            creaMapa(1);
        }catch(IOException e) {
            System.err.println("Mapa no se pudo crear.");
        }
        arrPersonajes = new LinkedList();
        arrEnemigos = new LinkedList();
        arrCementerio = new LinkedList();

        //si inicializan las distancias de los ataques
        distanciaAtaqueX = 150;
        distanciaAtaqueY = 150;
        distanciaEneAtaqueX = 80;
        distanciaEneAtaqueY = 100;
        // Se crean sonidos
        soundAtaque = new SoundClip ("hit.wav");
        soundBack = new SoundClip ("sonidoBack.wav");
        soundInicio = new SoundClip ("ini.wav");
        // Imagen de pociones
        urlG = this.getClass().getResource("hp1.png");
        imaPotion= Toolkit.getDefaultToolkit().getImage(urlG);
        // Imagenes de barra de vida
        urlG = this.getClass().getResource("life0.png");
        imaVida0 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("life25.png");
        imaVida25 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("life50.png");
        imaVida50 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("life75.png");
        imaVida75 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("life100.png");
        imaVida100 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Imagenes de menu
        urlG = this.getClass().getResource("menu1.png");
        imaMenu1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("menu2.png");
        imaMenu2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("menu3.png");
        imaMenu3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("menu4.png");
        imaMenu4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("menu5.png");
        imaMenu5 = Toolkit.getDefaultToolkit().getImage(urlG);
         // Animacion de muerte de enemigos
        urlG = this.getClass().getResource("cloud 1.png");
        Image imaHumo1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("cloud 2.png");
        Image imaHumo2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("cloud 3.png");
        Image imaHumo3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("cloud 4.png");
        Image imaHumo4 = Toolkit.getDefaultToolkit().getImage(urlG);

        // Movimiento del personaje principal estatico
        urlG = this.getClass().getResource("PP Camina Frente Estatico.png");
        Image imaMovFE = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Arriba Estatico.png");
        Image imaMovAE = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Izquierda Estatico.png");
        Image imaMovIE = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Derecha Estatico.png");
        Image imaMovDE = Toolkit.getDefaultToolkit().getImage(urlG);
          // Movimiento del personaje principal hacia el frete
        urlG = this.getClass().getResource("PP Camina Frente P1.png");
        Image imaMovF1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Frente P2.png");
        Image imaMovF2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Frente P3.png");
        Image imaMovF3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Frente P4.png");
        Image imaMovF4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Frente P5.png");
        Image imaMovF5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Frente P6.png");
        Image imaMovF6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Moviemiento del personaje principal hacia arriba
        urlG = this.getClass().getResource("PP Camina Arriba P1.png");
        Image imaMovA1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Arriba P2.png");
        Image imaMovA2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Arriba P3.png");
        Image imaMovA3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Arriba P4.png");
        Image imaMovA4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Arriba P5.png");
        Image imaMovA5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Arriba P6.png");
        Image imaMovA6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Movimiento del personaje principal hacia la derecha
        urlG = this.getClass().getResource("PP Camina Derecha P1.png");
        Image imaMovD1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Derecha P2.png");
        Image imaMovD2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Derecha P3.png");
        Image imaMovD3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Derecha P4.png");
        Image imaMovD4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Derecha P5.png");
        Image imaMovD5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Derecha P6.png");
        Image imaMovD6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Movimiento del personaje principal hacia la izquierda
        urlG = this.getClass().getResource("PP Camina Izquierda P1.png");
        Image imaMovI1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Izquierda P2.png");
        Image imaMovI2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Izquierda P3.png");
        Image imaMovI3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Izquierda P4.png");
        Image imaMovI4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Izquierda P5.png");
        Image imaMovI5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP Camina Izquierda P6.png");
        Image imaMovI6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Ataque del personaje principal a la izquierda
        urlG = this.getClass().getResource("PP ataca Izquierda P1.png");
        Image imaAtaI1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Izquierda P2.png");
        Image imaAtaI2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Izquierda P3.png");
        Image imaAtaI3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Izquierda P4.png");
        Image imaAtaI4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Izquierda P3.png");
        Image imaAtaI5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Izquierda P2.png");
        Image imaAtaI6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Ataque del personaje principal a la izquierda
        urlG = this.getClass().getResource("PP ataca Derecha P1.png");
        Image imaAtaD1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Derecha P2.png");
        Image imaAtaD2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Derecha P3.png");
        Image imaAtaD3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Derecha P4.png");
        Image imaAtaD4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Derecha P3.png");
        Image imaAtaD5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Derecha P2.png");
        Image imaAtaD6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Ataque del personaje principal hacia arriba
        urlG = this.getClass().getResource("PP ataca Arriba P1.png");
        Image imaAtaA1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Arriba P2.png");
        Image imaAtaA2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Arriba P3.png");
        Image imaAtaA3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Arriba P4.png");
        Image imaAtaA4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Arriba P3.png");
        Image imaAtaA5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Arriba P2.png");
        Image imaAtaA6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Ataque del personaje principal hacia abajo
        urlG = this.getClass().getResource("PP ataca Frente P1.png");
        Image imaAtaF1 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Frente P2.png");
        Image imaAtaF2 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Frente P3.png");
        Image imaAtaF3 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Frente P4.png");
        Image imaAtaF4 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Frente P3.png");
        Image imaAtaF5 = Toolkit.getDefaultToolkit().getImage(urlG);
        urlG = this.getClass().getResource("PP ataca Frente P2.png");
        Image imaAtaF6 = Toolkit.getDefaultToolkit().getImage(urlG);
        // Movimiento del enemigo 1 hacia arriba
        urlG = this.getClass().getResource("enemy1 up 1.png");
        Image imaMovMaloA1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 up 2.png");
        Image imaMovMaloA2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 up 3.png");
        Image imaMovMaloA3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Movimiento del enemigo 1 hacia  abajo
        urlG = this.getClass().getResource("enemy1 down 1.png");
        Image imaMovMaloF1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 down 2.png");
        Image imaMovMaloF2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 down 3.png");
        Image imaMovMaloF3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Movimiento del enemigo 1 hacia Izquierda
        urlG = this.getClass().getResource("enemy1 left 1.png");
        Image imaMovMaloI1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 left 3.png");
        Image imaMovMaloI2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 left 3.png");
        Image imaMovMaloI3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Movimiento del enemigo 1 hacia derecha
        urlG = this.getClass().getResource("enemy1 right 1.png");
        Image imaMovMaloD1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 right 2.png");
        Image imaMovMaloD2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 right 3.png");
        Image imaMovMaloD3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia arriba
        urlG = this.getClass().getResource("enemy1 upattack 1.png");
        Image imaAtaMaloA1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 upattack 2.png");
        Image imaAtaMaloA2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 upattack 3.png");
        Image imaAtaMaloA3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia abajo
        urlG = this.getClass().getResource("enemy1 downattack 1.png");
        Image imaAtaMaloF1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 downattack 2.png");
        Image imaAtaMaloF2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 downattack 3.png");
        Image imaAtaMaloF3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia izquierda
        urlG = this.getClass().getResource("enemy1 leftattack 1.png");
        Image imaAtaMaloI1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 leftattack 2.png");
        Image imaAtaMaloI2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 leftattack 3.png");
        Image imaAtaMaloI3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia Derecha
        urlG = this.getClass().getResource("enemy1 rightattack 1.png");
        Image imaAtaMaloD1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 rightattack 2.png");
        Image imaAtaMaloD2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy1 rightattack 3.png");
        Image imaAtaMaloD3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
                // Movimiento del enemigo 2 hacia arriba
        urlG = this.getClass().getResource("enemy2 up 1.png");
        Image imaMovMalo2A1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 up 2.png");
        Image imaMovMalo2A2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 up 3.png");
        Image imaMovMalo2A3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Movimiento del enemigo 2 hacia  abajo
        urlG = this.getClass().getResource("enemy2 down 1.png");
        Image imaMovMalo2F1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 down 2.png");
        Image imaMovMalo2F2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 down 3.png");
        Image imaMovMalo2F3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Movimiento del enemigo 2 hacia Izquierda
        urlG = this.getClass().getResource("enemy2 left 1.png");
        Image imaMovMalo2I1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 left 2.png");
        Image imaMovMalo2I2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 left 3.png");
        Image imaMovMalo2I3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Movimiento del enemigo 2 hacia derecha
        urlG = this.getClass().getResource("enemy2 right 1.png");
        Image imaMovMalo2D1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 right 2.png");
        Image imaMovMalo2D2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 right 3.png");
        Image imaMovMalo2D3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo2 hacia arriba
        urlG = this.getClass().getResource("enemy2 upattack 2.png");
        Image imaAtaMalo2A1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 upattack 3.png");
        Image imaAtaMalo2A2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 upattack 4.png");
        Image imaAtaMalo2A3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia abajo
        urlG = this.getClass().getResource("enemy2 downattack 2.png");
        Image imaAtaMalo2F1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 downattack 3.png");
        Image imaAtaMalo2F2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 downattack 4.png");
        Image imaAtaMalo2F3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia izquierda
        urlG = this.getClass().getResource("enemy2 leftattack2.png");
        Image imaAtaMalo2I1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 leftattack3.png");
        Image imaAtaMalo2I2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 leftattack4.png");
        Image imaAtaMalo2I3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Ataque del malo1 hacia Derecha
        urlG = this.getClass().getResource("enemy2 rightattack2.png");
        Image imaAtaMalo2D1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 rightattack3.png");
        Image imaAtaMalo2D2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("enemy2 rightattack4.png");
        Image imaAtaMalo2D3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char1 1.png");
        Image imaNpc1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char1 2.png");
        Image imaNpc2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char1 3.png");
        Image imaNpc3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char1 4.png");
        Image imaNpc4 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char2 1.png");
        Image imaNpc5 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char2 2.png");
        Image imaNpc6 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char2 3.png");
        Image imaNpc7 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char2 4.png");
        Image imaNpc8 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char3 1.png");
        Image imaNpc9 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char3 2.png");
        Image imaNpc10 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char3 3.png");
        Image imaNpc11 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char3 4.png");
        Image imaNpc12 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char4 1.png");
        Image imaNpc13 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char4 2.png");
        Image imaNpc14 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char4 3.png");
        Image imaNpc15 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char4 4.png");
        Image imaNpc16 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char5 1.png");
        Image imaNpc17 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char5 2.png");
        Image imaNpc18 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char5 3.png");
        Image imaNpc19 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("char5 4.png");
        Image imaNpc20 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        // Imagenes del jefe
        urlG = this.getClass().getResource("boss down 1.png");
        Image imaJefeMovF1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss down 2.png");
        Image imaJefeMovF2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss down 3.png");
        Image imaJefeMovF3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss up 1.png");
        Image imaJefeMovA1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss up 2.png");
        Image imaJefeMovA2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss up 3.png");
        Image imaJefeMovA3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss right1.png");
        Image imaJefeMovD1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss right2.png");
        Image imaJefeMovD2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss right3.png");
        Image imaJefeMovD3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss left1.png");
        Image imaJefeMovI1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss left2.png");
        Image imaJefeMovI2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss left3.png");
        Image imaJefeMovI3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        //Ataques del jefe
        urlG = this.getClass().getResource("boss attackdown 1.png");
        Image imaAtaJefeF1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackdown 2.png");
        Image imaAtaJefeF2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackdown 3.png");
        Image imaAtaJefeF3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackup 1.png");
        Image imaAtaJefeA1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackup 2.png");
        Image imaAtaJefeA2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackup 3.png");
        Image imaAtaJefeA3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackright 1.png");
        Image imaAtaJefeD1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackright 2.png");
        Image imaAtaJefeD2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackright 3.png");
        Image imaAtaJefeD3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        Image imaAtaJefeI1 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackleft 2.png");
        Image imaAtaJefeI2 = Toolkit.getDefaultToolkit()
                .getImage(urlG);
        urlG = this.getClass().getResource("boss attackleft 3.png");
        Image imaAtaJefeI3 = Toolkit.getDefaultToolkit()
                .getImage(urlG);

        // Lista del inventario del personaje
        LinkedList invent = new LinkedList();
        //animacion del npc
        aniNpc1 = new Animacion();
        aniNpc1.sumaCuadro(imaNpc1, 100);
        //Animaciones estaticas de movimiento de personaje principal
        aniMovFE = new Animacion();
        aniMovFE.sumaCuadro(imaMovFE, 100);
        aniMovAE = new Animacion();
        aniMovAE.sumaCuadro(imaMovAE, 100);
        aniMovIE = new Animacion();
        aniMovIE.sumaCuadro(imaMovIE, 100);
        aniMovDE = new Animacion();
        aniMovDE.sumaCuadro(imaMovDE, 100);
        // Animación de movimiento para enfrente
        aniMovF = new Animacion();
        aniMovF.sumaCuadro(imaMovF1, 100);
        aniMovF.sumaCuadro(imaMovF2, 100);
        aniMovF.sumaCuadro(imaMovF3, 100);
        aniMovF.sumaCuadro(imaMovF4, 100);
        aniMovF.sumaCuadro(imaMovF5, 100);
        aniMovF.sumaCuadro(imaMovF6, 100);
        // Animacion del movimiento hacia la izquierda
        aniMovI = new Animacion();
        aniMovI.sumaCuadro(imaMovI1, 100);
        aniMovI.sumaCuadro(imaMovI2, 100);
        aniMovI.sumaCuadro(imaMovI3, 100);
        aniMovI.sumaCuadro(imaMovI4, 100);
        aniMovI.sumaCuadro(imaMovI5, 100);
        aniMovI.sumaCuadro(imaMovI6, 100);
        // Animacion del movimineto hacia arriba
        aniMovA = new Animacion();
        aniMovA.sumaCuadro(imaMovA1, 100);
        aniMovA.sumaCuadro(imaMovA2, 100);
        aniMovA.sumaCuadro(imaMovA3, 100);
        aniMovA.sumaCuadro(imaMovA4, 100);
        aniMovA.sumaCuadro(imaMovA5, 100);
        aniMovA.sumaCuadro(imaMovA6, 100);
        // Animacion del movimiento hacia la derecha
        aniMovD = new Animacion();
        aniMovD.sumaCuadro(imaMovD1, 100);
        aniMovD.sumaCuadro(imaMovD2, 100);
        aniMovD.sumaCuadro(imaMovD3, 100);
        aniMovD.sumaCuadro(imaMovD4, 100);
        aniMovD.sumaCuadro(imaMovD5, 100);
        aniMovD.sumaCuadro(imaMovD6, 100);
        // Animacion del ataque hacia la derecha
        aniAtaD = new Animacion();
        aniAtaD.sumaCuadro(imaAtaD1, 50);
        aniAtaD.sumaCuadro(imaAtaD2, 50);
        aniAtaD.sumaCuadro(imaAtaD3, 50);
        aniAtaD.sumaCuadro(imaAtaD4, 50);
        aniAtaD.sumaCuadro(imaAtaD5, 50);
        aniAtaD.sumaCuadro(imaAtaD6, 50);
        // Animacion del ataque hacia la izquierda
        aniAtaI = new Animacion();
        aniAtaI.sumaCuadro(imaAtaI1, 50);
        aniAtaI.sumaCuadro(imaAtaI2, 50);
        aniAtaI.sumaCuadro(imaAtaI3, 50);
        aniAtaI.sumaCuadro(imaAtaI4, 50);
        aniAtaI.sumaCuadro(imaAtaI5, 50);
        aniAtaI.sumaCuadro(imaAtaI6, 50);
        // Animacion del ataque hacia arriba
        aniAtaA = new Animacion();
        aniAtaA.sumaCuadro(imaAtaA1, 50);
        aniAtaA.sumaCuadro(imaAtaA2, 50);
        aniAtaA.sumaCuadro(imaAtaA3, 50);
        aniAtaA.sumaCuadro(imaAtaA4, 50);
        aniAtaA.sumaCuadro(imaAtaA5, 50);
        aniAtaA.sumaCuadro(imaAtaA6, 50);
        // Animacion del ataque hacia el frente
        aniAtaF = new Animacion();
        aniAtaF.sumaCuadro(imaAtaF1, 50);
        aniAtaF.sumaCuadro(imaAtaF2, 50);
        aniAtaF.sumaCuadro(imaAtaF3, 50);
        aniAtaF.sumaCuadro(imaAtaF4, 50);
        aniAtaF.sumaCuadro(imaAtaF5, 50);
        aniAtaF.sumaCuadro(imaAtaF6, 50);
        // Animación de movimiento para enfrente malo
        aniMovFMalo = new Animacion();
        aniMovFMalo.sumaCuadro(imaMovMaloF1, 100);
        aniMovFMalo.sumaCuadro(imaMovMaloF2, 100);
        aniMovFMalo.sumaCuadro(imaMovMaloF1, 100);
        aniMovFMalo.sumaCuadro(imaMovMaloF3, 100);
        // Animacion del movimiento hacia la izquierda malo
        aniMovIMalo = new Animacion();
        aniMovIMalo.sumaCuadro(imaMovMaloI1, 100);
        aniMovIMalo.sumaCuadro(imaMovMaloI2, 100);
        aniMovIMalo.sumaCuadro(imaMovMaloI1, 100);
        aniMovIMalo.sumaCuadro(imaMovMaloI3, 100);
        // Animacion del movimineto hacia arriba malo
        aniMovAMalo = new Animacion();
        aniMovAMalo.sumaCuadro(imaMovMaloA1, 100);
        aniMovAMalo.sumaCuadro(imaMovMaloA2, 100);
        aniMovAMalo.sumaCuadro(imaMovMaloA1, 100);
        aniMovAMalo.sumaCuadro(imaMovMaloA3, 100);
        // Animacion del movimiento hacia la derecha malo
        aniMovDMalo = new Animacion();
        aniMovDMalo.sumaCuadro(imaMovMaloD1, 100);
        aniMovDMalo.sumaCuadro(imaMovMaloD2, 100);
        aniMovDMalo.sumaCuadro(imaMovMaloD1, 100);
        aniMovDMalo.sumaCuadro(imaMovMaloD3, 100);
         // Animacion del ataque hacia la derecha malo
        aniAtaDMalo = new Animacion();
        aniAtaDMalo.sumaCuadro(imaAtaMaloD1, 80);
        aniAtaDMalo.sumaCuadro(imaAtaMaloD2, 80);
        aniAtaDMalo.sumaCuadro(imaAtaMaloD3, 80);
        // Animacion del ataque hacia la izquierda malo
        aniAtaIMalo = new Animacion();
        aniAtaIMalo.sumaCuadro(imaAtaMaloI1, 80);
        aniAtaIMalo.sumaCuadro(imaAtaMaloI2, 80);
        aniAtaIMalo.sumaCuadro(imaAtaMaloI3, 80);
        // Animacion del ataque hacia arriba malo
        aniAtaAMalo = new Animacion();
        aniAtaAMalo.sumaCuadro(imaAtaMaloA1, 80);
        aniAtaAMalo.sumaCuadro(imaAtaMaloA2, 80);
        aniAtaAMalo.sumaCuadro(imaAtaMaloA3, 80);
        // Animacion del ataque hacia el frente malo
        aniAtaFMalo = new Animacion();
        aniAtaFMalo.sumaCuadro(imaAtaMaloF1, 80);
        aniAtaFMalo.sumaCuadro(imaAtaMaloF2, 80);
        aniAtaFMalo.sumaCuadro(imaAtaMaloF3, 80);
        // Animación de movimiento para enfrente malo 2
        aniMovFMalo2 = new Animacion();
        aniMovFMalo2.sumaCuadro(imaMovMalo2F1, 100);
        aniMovFMalo2.sumaCuadro(imaMovMalo2F2, 100);
        aniMovFMalo2.sumaCuadro(imaMovMalo2F1, 100);
        aniMovFMalo2.sumaCuadro(imaMovMalo2F3, 100);
        // Animacion del movimiento hacia la izquierda malo 2
        aniMovIMalo2 = new Animacion();
        aniMovIMalo2.sumaCuadro(imaMovMalo2I1, 100);
        aniMovIMalo2.sumaCuadro(imaMovMalo2I2, 100);
        aniMovIMalo2.sumaCuadro(imaMovMalo2I1, 100);
        aniMovIMalo2.sumaCuadro(imaMovMalo2I3, 100);
        // Animacion del movimineto hacia arriba malo 2
        aniMovAMalo2 = new Animacion();
        aniMovAMalo2.sumaCuadro(imaMovMalo2A1, 100);
        aniMovAMalo2.sumaCuadro(imaMovMalo2A2, 100);
        aniMovAMalo2.sumaCuadro(imaMovMalo2A1, 100);
        aniMovAMalo2.sumaCuadro(imaMovMalo2A3, 100);
        // Animacion del movimiento hacia la derecha malo 2
        aniMovDMalo2 = new Animacion();
        aniMovDMalo2.sumaCuadro(imaMovMalo2D1, 100);
        aniMovDMalo2.sumaCuadro(imaMovMalo2D2, 100);
        aniMovDMalo2.sumaCuadro(imaMovMalo2D1, 100);
        aniMovDMalo2.sumaCuadro(imaMovMalo2D3, 100);
         // Animacion del ataque hacia la derecha malo
        aniAtaDMalo2 = new Animacion();
        aniAtaDMalo2.sumaCuadro(imaAtaMalo2D1, 80);
        aniAtaDMalo2.sumaCuadro(imaAtaMalo2D2, 80);
        aniAtaDMalo2.sumaCuadro(imaAtaMalo2D3, 80);
        // Animacion del ataque hacia la izquierda malo
        aniAtaIMalo2 = new Animacion();
        aniAtaIMalo2.sumaCuadro(imaAtaMalo2I1, 80);
        aniAtaIMalo2.sumaCuadro(imaAtaMalo2I2, 80);
        aniAtaIMalo2.sumaCuadro(imaAtaMalo2I3, 80);
        // Animacion del ataque hacia arriba malo
        aniAtaAMalo2 = new Animacion();
        aniAtaAMalo2.sumaCuadro(imaAtaMalo2A1, 80);
        aniAtaAMalo2.sumaCuadro(imaAtaMalo2A2, 80);
        aniAtaAMalo2.sumaCuadro(imaAtaMalo2A3, 80);
        // Animacion del ataque hacia el frente malo
        aniAtaFMalo2 = new Animacion();
        aniAtaFMalo2.sumaCuadro(imaAtaMalo2F1, 80);
        aniAtaFMalo2.sumaCuadro(imaAtaMalo2F2, 80);
        aniAtaFMalo2.sumaCuadro(imaAtaMalo2F3, 80);
        // Animacion de muerte de malos
        aniMuerte = new Animacion();
        aniMuerte.sumaCuadro(imaHumo1, 80);
        aniMuerte.sumaCuadro(imaHumo2, 80);
        aniMuerte.sumaCuadro(imaHumo3, 80);
        aniMuerte.sumaCuadro(imaHumo4, 80);
        // Animacion de movimineto del malo
        aniMovFJefe = new Animacion();
        aniMovFJefe.sumaCuadro(imaJefeMovF1,100);
        aniMovFJefe.sumaCuadro(imaJefeMovF2,100);
        aniMovFJefe.sumaCuadro(imaJefeMovF1,100);
        aniMovFJefe.sumaCuadro(imaJefeMovF3,100);
        aniMovAJefe = new Animacion();
        aniMovAJefe.sumaCuadro(imaJefeMovA1,100);
        aniMovAJefe.sumaCuadro(imaJefeMovA2,100);
        aniMovAJefe.sumaCuadro(imaJefeMovA1,100);
        aniMovAJefe.sumaCuadro(imaJefeMovA3,100);
        aniMovDJefe = new Animacion();
        aniMovDJefe.sumaCuadro(imaJefeMovD1,100);
        aniMovDJefe.sumaCuadro(imaJefeMovD2,100);
        aniMovDJefe.sumaCuadro(imaJefeMovD1,100);
        aniMovDJefe.sumaCuadro(imaJefeMovD3,100);
        aniMovIJefe = new Animacion();
        aniMovIJefe.sumaCuadro(imaJefeMovI1,100);
        aniMovIJefe.sumaCuadro(imaJefeMovI2,100);
        aniMovIJefe.sumaCuadro(imaJefeMovI1,100);
        aniMovIJefe.sumaCuadro(imaJefeMovI3,100);
        //Animacion de ataque de jefe
        aniAtaFJefe = new Animacion();
        aniAtaFJefe.sumaCuadro(imaAtaJefeF1,100);
        aniAtaFJefe.sumaCuadro(imaAtaJefeF2,100);
        aniAtaFJefe.sumaCuadro(imaAtaJefeF3,100);
        aniAtaAJefe = new Animacion();
        aniAtaAJefe.sumaCuadro(imaAtaJefeA1,100);
        aniAtaAJefe.sumaCuadro(imaAtaJefeA2,100);
        aniAtaAJefe.sumaCuadro(imaAtaJefeA3,100);
        aniAtaIJefe = new Animacion();
        aniAtaIJefe.sumaCuadro(imaAtaJefeI1,100);
        aniAtaIJefe.sumaCuadro(imaAtaJefeI2,100);
        aniAtaIJefe.sumaCuadro(imaAtaJefeI3,100);
        aniAtaDJefe = new Animacion();
        aniAtaDJefe.sumaCuadro(imaAtaJefeD1,100);
        aniAtaDJefe.sumaCuadro(imaAtaJefeD2,100);
        aniAtaDJefe.sumaCuadro(imaAtaJefeD3,100);



        // Se crea el personaje principal
        charPersonaje = new Character(100, 100, imaMovI3, aniMovF ,
                idPersonajes++, 100, 100, 10, 1,
                true, invent, true );
        charPersonaje.setX((getWidth() / 2)-50);//-charPersonaje.getAncho()/2);
        charPersonaje.setY((getHeight() / 2)-50);//-charPersonaje.getAlto()/2);

        // Se crea a npcs
        for (int i = 0; i<1; i++){
            Character charNpc = new Character(100, 100, imaNpc2, aniNpc1 ,
                    idNpc++, 100, 100, 3, 1,
                    false, invent, true );
            charNpc.setX(700);
            charNpc.setY(500);
            arrNpcs.add(charNpc);
        }




        // Se crean enemigo de tipo 1
        for(int i = 0; i<4;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 0, 1,false, invent, true );
            charEnemigo.setTipo(1);
            charEnemigo.setMov(false);
            charEnemigo.setHp(100);
            charEnemigo.setX(5700+500*i);
            charEnemigo.setY(1800);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<4;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo2 ,
                    idPersonajes++, 200, 100, 0, 1,false, invent, true );
            charEnemigo.setMov(false);
            charEnemigo.setTipo(2);
            charEnemigo.setHp(250);
            charEnemigo.setX(5700+500*i);
            charEnemigo.setY(2300);
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<6;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(1);
            charEnemigo.setMov(false);
            charEnemigo.setHp(100);
            charEnemigo.setX(9700+500*i);
            charEnemigo.setY(1900);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<4;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(2);
            charEnemigo.setMov(false);
            charEnemigo.setHp(250);
            charEnemigo.setX(9900+500*i);
            charEnemigo.setY(2000);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<4;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(2);
            charEnemigo.setMov(false);
            charEnemigo.setHp(250);
            charEnemigo.setX(9700+500*i);
            charEnemigo.setY(1700);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<4;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(2);
            charEnemigo.setMov(false);
            charEnemigo.setHp(250);
            charEnemigo.setX(9700+500*i);
            charEnemigo.setY(2200);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<8;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(1);
            charEnemigo.setMov(false);
            charEnemigo.setHp(100);
            charEnemigo.setX(9900+500*i);
            charEnemigo.setY(1900);
            
            arrEnemigos.add(charEnemigo);
        }
        // Se crea enemigo de tipo 2
        for(int i = 0; i<8;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo2 ,
                    idPersonajes++, 200, 100, 3, 1,false, invent, true );
            charEnemigo.setMov(false);
            charEnemigo.setTipo(2);
            charEnemigo.setHp(250);
            charEnemigo.setX(9900+500*i);
            charEnemigo.setY(2000);
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<7;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo2 ,
                    idPersonajes++, 200, 100, 3, 1,false, invent, true );
            charEnemigo.setMov(false);
            charEnemigo.setTipo(2);
            charEnemigo.setHp(250);
            charEnemigo.setX(13900+500*i);
            charEnemigo.setY(3500);
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<6;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo2 ,
                    idPersonajes++, 200, 100, 3, 1,false, invent, true );
            charEnemigo.setMov(false);
            charEnemigo.setTipo(2);
            charEnemigo.setHp(250);
            charEnemigo.setX(11700+500*i);
            charEnemigo.setY(3800);
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<3;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(1);
            charEnemigo.setMov(false);
            charEnemigo.setHp(100);
            charEnemigo.setX(12000+500*i);
            charEnemigo.setY(3800);
            
            arrEnemigos.add(charEnemigo);
        }
            addKeyListener(this);
            
            
        for(int i = 0; i<3;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(1);
            charEnemigo.setMov(false);
            charEnemigo.setHp(100);
            charEnemigo.setX(15000+500*i);
            charEnemigo.setY(1700);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<6;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo ,
                    idPersonajes++, 100, 100, 3, 1,false, invent, true );
            charEnemigo.setTipo(1);
            charEnemigo.setMov(false);
            charEnemigo.setHp(100);
            charEnemigo.setX(15000+500*i);
            charEnemigo.setY(2400);
            
            arrEnemigos.add(charEnemigo);
        }
        
        for(int i = 0; i<6;i++) {
            Character charEnemigo = new Character
            (60*idPersonajes, 43*idPersonajes, imaMovI3, aniMovFMalo2 ,
                    idPersonajes++, 200, 100, 3, 1,false, invent, true );
            charEnemigo.setMov(false);
            charEnemigo.setTipo(2);
            charEnemigo.setHp(250);
            charEnemigo.setX(16500+500*i);
            charEnemigo.setY(1800);
            arrEnemigos.add(charEnemigo);
        }

        // Se crea el jefe
        idJefe = idPersonajes;
        Character charEnemigo = new Character
        (100, 100, imaMovI3, aniMovFJefe ,
                idPersonajes++, 500, 100, 4, 1,false, invent, true );
        charEnemigo.setMov(false);
        charEnemigo.setTipo(3);
        charEnemigo.setHp(500);
        charEnemigo.setX(17900);
            charEnemigo.setY(1800);
        arrEnemigos.add(charEnemigo);
        
        try{
            grabarJuegoInicial();
        }catch(IOException p) {
            System.err.println("error grabando el juego");
        }
   }


    public Trigger(){
        init();
        start();
    }

    public void start() {
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
    }


    @Override
    public void run () {
        // se realiza el ciclo del juego en este caso nunca termina
        tiempoActual = System.currentTimeMillis();
        if (bMenu){
        soundInicio.play();
        }
        soundBack.setLooping(true);
        soundBack.play();
        while (true) {
            /* mientras dure el juego, se actualizan posiciones de jugadores
               se checa si hubo colisiones para desaparecer jugadores o corregir
               movimientos y se vuelve a pintar todo
            */
            if(!bMenu) {
            actualiza();
            }
            // Si un enemigo no tiene vidas se manda al arreglo del cementerio
            checaColision();
            repaint();
            try {
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError)   {
                System.out.println("Hubo un error en el juego " +
                        iexError.toString());
            }
        }
    }

    /*
        Funcion encargada de incrementar contadores,
        cambiar la posicion y animaciones de los personajes y el terreno
        y borrar a los personajes muertos.
    */


    public void actualiza(){
        // Tiempo transcurrido desde que inicio el juego
        bInicio = true;
        long tiempoTranscurrido=System.currentTimeMillis() - tiempoActual;
        tiempoActual += tiempoTranscurrido;
        tiempoDAtaque++;
        contadorAtaqueMain++;
        //Guarda el tiempo actual
        aggro(); //se mueve a los enemigos
        enemigoCombate(); //los enemigos atacan
        if (bMovimiento){
            //Actualiza las animaciones del personaje en movimiento
            aniMovF.actualiza(tiempoTranscurrido);
            aniMovA.actualiza(tiempoTranscurrido);
            aniMovD.actualiza(tiempoTranscurrido);
            aniMovI.actualiza(tiempoTranscurrido);

        }
        // Se actualizan las animaciones de los ataques de los personajes
        if (bAtaque && iContAni <=6){
            aniAtaI.actualiza(tiempoTranscurrido);
            aniAtaD.actualiza(tiempoTranscurrido);
            aniAtaF.actualiza(tiempoTranscurrido);
            aniAtaA.actualiza(tiempoTranscurrido);
            iContAni++;
            if (iContAni == 6){
                aniAtaI.iniciar();
                aniAtaD.iniciar();
                aniAtaA.iniciar();
                aniAtaF.iniciar();
            }
        }
        // Actualiza animaciones del malo 1 y 2
        aniMovFMalo.actualiza(tiempoTranscurrido);
        aniMovAMalo.actualiza(tiempoTranscurrido);
        aniMovDMalo.actualiza(tiempoTranscurrido);
        aniMovIMalo.actualiza(tiempoTranscurrido);
        aniAtaIMalo.actualiza(tiempoTranscurrido);
        aniAtaDMalo.actualiza(tiempoTranscurrido);
        aniAtaFMalo.actualiza(tiempoTranscurrido);
        aniAtaAMalo.actualiza(tiempoTranscurrido);
        aniMovFMalo2.actualiza(tiempoTranscurrido);
        aniMovAMalo2.actualiza(tiempoTranscurrido);
        aniMovDMalo2.actualiza(tiempoTranscurrido);
        aniMovIMalo2.actualiza(tiempoTranscurrido);
        aniAtaIMalo2.actualiza(tiempoTranscurrido);
        aniAtaDMalo2.actualiza(tiempoTranscurrido);
        aniAtaFMalo2.actualiza(tiempoTranscurrido);
        aniAtaAMalo2.actualiza(tiempoTranscurrido);
        aniAtaIJefe.actualiza(tiempoTranscurrido);
        aniAtaDJefe.actualiza(tiempoTranscurrido);
        aniAtaFJefe.actualiza(tiempoTranscurrido);
        aniAtaAJefe.actualiza(tiempoTranscurrido);
        aniMovFJefe.actualiza(tiempoTranscurrido);
        aniMovAJefe.actualiza(tiempoTranscurrido);
        aniMovDJefe.actualiza(tiempoTranscurrido);
        aniMovIJefe.actualiza(tiempoTranscurrido);
        // Actualiza animaciones estaticas
        aniMovFE.actualiza(tiempoTranscurrido);
        aniMovAE.actualiza(tiempoTranscurrido);
        aniMovDE.actualiza(tiempoTranscurrido);
        aniMovIE.actualiza(tiempoTranscurrido);
        //Actualiza animaciones de la muerte
        aniMuerte.actualiza(tiempoTranscurrido);
        // Actualiza animacion de npc
        aniNpc1.actualiza(tiempoTranscurrido);

        // Si no esta en movimiento y ataque que se quede en su posicion
        // Estatica el personaje principal
        if (!bMovimiento && !bAtaque){
            if (charPersonaje.getDir() == 1)
                charPersonaje.setAnimacion(aniMovIE);
            else if (charPersonaje.getDir() == 2)
                charPersonaje.setAnimacion(aniMovDE);
            else if (charPersonaje.getDir() == 3)
                charPersonaje.setAnimacion(aniMovAE);
            else if (charPersonaje.getDir() == 4)
                charPersonaje.setAnimacion(aniMovFE);
        }
        // Contador para que funcione la trancision de animacion de movimiento
        // a ataque de los enemigos
        for (Object monstruo : arrEnemigos) {   //se buscara a los enemigos
            Character enemigo = (Character)monstruo;
            if (!enemigo.getMov()){
                    iContAniMalo++;
                if(iContAniMalo > 10){
                    enemigo.setMov(true);
                    iContAniMalo = 0;
                }
            }
        }

        if (bFisica1){
            iContFisica++;
                if(iContFisica > 15){
                    bFisica1 = false;
                    iContFisica = 0;
                }
        }

        for (Object monstruo : arrEnemigos) {
            Character enemigo = (Character)monstruo;
            if(!enemigo.getIsAlive()) {
                enemigo.setMov(false);
                enemigo.setTipo(0);
                enemigo.setAnimacion(aniMuerte);
                iContAniMuerte++;
                if(iContAniMuerte > 10){
                    enemigo.setX(2000);
                    enemigo.setY(2000);
                    iContAniMuerte = 0;
                 }
            }
        }



        // Movimiento del personaje hacia cada lado
        // Direccion 1 = Izquierda
        // Direccion 2 = Derecha
        // Direccion 3 = Arriba
        // Direccion 4 = Abajo
        switch (charPersonaje.getDir()){
            case 1:{
                if(bMovimiento) {
                    charPersonaje.setAnimacion(aniMovI);
                    for (Object tile : map) {
                        Terrain bloque = (Terrain)tile;
                        if(!bloque.getIsWalkable() &&charPersonaje.getX() >= bloque.getX()&&
                                Math.abs(charPersonaje.getX() - bloque.getX()) <= distanciaProxPrin && Math.abs(charPersonaje.getY() - bloque.getY())<=distanciaProxSec) {
                            bMovimiento = false;
//                            charPersonaje.setX(bloque.getX()+100);
                            break;
                        }
                    }
                    for (Object monstruo : arrEnemigos) {
                         Character enemigo = (Character)monstruo;
                        if(Math.abs(charPersonaje.getX() - enemigo.getX()) <=80 &&
                                Math.abs(charPersonaje.getY() - enemigo.getY())
                                < 50) {//checa si hay algo atravezado
                            if(charPersonaje.getX() >= enemigo.getX()){
                            bMovimiento = false;
                            break;}
                        }
                        if(bMovimiento) {
                            enemigo.setX(enemigo.getX() + charPersonaje.getSpeed());
                        }
                    }
                    for (Object secundario : arrNpcs) {
                         Character npc = (Character)secundario;
                        if(Math.abs(charPersonaje.getX() - npc.getX()) <=80 &&
                                Math.abs(charPersonaje.getY() - npc.getY())
                                < 50) {//checa si hay algo atravezado
                            if(charPersonaje.getX() >= npc.getX()){
                            bMovimiento = false;
                            break;}
                        }
                        if(bMovimiento) {
                            npc.setX(npc.getX() + charPersonaje.getSpeed());
                        }
                    }
                    if(bMovimiento) {
                        for (Object tile : map) {
                            Terrain bloque = (Terrain)tile;
                            bloque.setX(bloque.getX() + charPersonaje.getSpeed());
                        }
                    }
                }
                break;
            }
            case 2:{
                if(bMovimiento) {
                    charPersonaje.setAnimacion(aniMovD);
                    for (Object tile : map) {
                        Terrain bloque = (Terrain)tile;
                        if(!bloque.getIsWalkable() && bloque.getX() >= charPersonaje.getX()&&
                                Math.abs(charPersonaje.getX() - bloque.getX()) <= distanciaProxPrin && Math.abs(charPersonaje.getY() - bloque.getY())<=distanciaProxSec) {
                            bMovimiento = false;
//                            charPersonaje.setX(bloque.getX()+100);
                            break;
                        }
                    }
                    if(bMovimiento){
                        for (Object tile : map) {
                            Terrain bloque = (Terrain)tile;
                            bloque.setX(bloque.getX() - charPersonaje.getSpeed());
                        }
                    }
                    for (Object monstruo : arrEnemigos) {
                        Character enemigo = (Character)monstruo;
                        if(Math.abs(charPersonaje.getX() - enemigo.getX()) <=80 &&
                                Math.abs(charPersonaje.getY() - enemigo.getY()) <
                                50) {//checa si hay algo atravezado
                            if(enemigo.getX() >= charPersonaje.getX()) {
                            bMovimiento = false;
                            break;}
                        }
                        if(bMovimiento){
                            enemigo.setX(enemigo.getX() - charPersonaje.getSpeed());
                        }
                    }

                    for (Object secundario : arrNpcs) {
                        Character npc = (Character)secundario;
                        if(Math.abs(charPersonaje.getX() - npc.getX()) <=80 &&
                                Math.abs(charPersonaje.getY() - npc.getY()) <
                                50) {//checa si hay algo atravezado
                            if(npc.getX() >= charPersonaje.getX()) {
                            bMovimiento = false;
                            break;}
                        }
                        if(bMovimiento){
                            npc.setX(npc.getX() - charPersonaje.getSpeed());
                        }
                    }
                }
                break;
            }
            case 3:{
                if(bMovimiento) {
                    charPersonaje.setAnimacion(aniMovA);
                    for (Object tile : map) {
                        Terrain bloque = (Terrain)tile;
                        if(!bloque.getIsWalkable() &&charPersonaje.getY() >= bloque.getY() &&
                                Math.abs(charPersonaje.getY() - bloque.getY()) <= distanciaProxPrin && Math.abs(charPersonaje.getX() - bloque.getX())<=distanciaProxSec) {
                            bMovimiento = false;
//                            charPersonaje.setX(bloque.getX()+100);
                            break;
                        }
                    }
                    if(bMovimiento){
                        for (Object tile : map) {
                            Terrain bloque = (Terrain)tile;
                            bloque.setY(bloque.getY() + charPersonaje.getSpeed());
                        }
                    }
                    for (Object monstruo : arrEnemigos) {
                    Character enemigo = (Character)monstruo;
                    if(Math.abs(charPersonaje.getY() - enemigo.getY()) <=80 &&
                            Math.abs(charPersonaje.getX() - enemigo.getX()) <
                            50) {//checa si hay algo atravezado
                        if(charPersonaje.getY() >= enemigo.getY()){
                        bMovimiento = false;
                        break;
                        }
                    }
                    if(bMovimiento){
                        enemigo.setY(enemigo.getY() + charPersonaje.getSpeed());
                        }
                    }

                    for (Object secundario : arrNpcs) {
                    Character npc = (Character)secundario;
                    if(Math.abs(charPersonaje.getY() - npc.getY()) <=80 &&
                            Math.abs(charPersonaje.getX() - npc.getX()) <
                            50) {//checa si hay algo atravezado
                        if(charPersonaje.getY() >= npc.getY()){
                        bMovimiento = false;
                        break;
                        }
                    }
                    if(bMovimiento){
                        npc.setY(npc.getY() + charPersonaje.getSpeed());
                        }
                    }
                }
                break;
            }
            case 4:{
                if(bMovimiento) {
                    charPersonaje.setAnimacion(aniMovF);
                    for (Object tile : map) {
                        Terrain bloque = (Terrain)tile;
                        if(!bloque.getIsWalkable() &&charPersonaje.getY() <= bloque.getY() &&
                                Math.abs(charPersonaje.getY()+50 - bloque.getY()) <= distanciaProxPrin && Math.abs(charPersonaje.getX() - bloque.getX())<=distanciaProxSec) {
                            bMovimiento = false;
//                            charPersonaje.setX(bloque.getX()+100);
                            break;
                        }
                    }
                    if(bMovimiento){
                        for (Object tile : map) {
                            Terrain bloque = (Terrain)tile;
                            bloque.setY(bloque.getY() - charPersonaje.getSpeed());
                        }
                    }
                    for (Object monstruo : arrEnemigos) {
                    Character enemigo = (Character)monstruo;
                    if(Math.abs(enemigo.getY() - charPersonaje.getY()) <=80 &&
                            Math.abs(charPersonaje.getX() - enemigo.getX()) <
                            50) {//checa si hay algo atravezado
                        if(charPersonaje.getY() <= enemigo.getY()) {
                        bMovimiento = false;
                        break;
                        }
                    }
                        if(bMovimiento){
                            enemigo.setY(enemigo.getY() - charPersonaje.getSpeed());
                        }
                    }

                    for (Object secundario : arrNpcs) {
                    Character npc = (Character)secundario;
                    if(Math.abs(npc.getY() - charPersonaje.getY()) <=80 &&
                            Math.abs(charPersonaje.getX() - npc.getX()) <
                            50) {//checa si hay algo atravezado
                        if(charPersonaje.getY() <= npc.getY()) {
                        bMovimiento = false;
                        break;
                        }
                    }
                        if(bMovimiento){
                            npc.setY(npc.getY() - charPersonaje.getSpeed());
                        }
                    }
                }
                break;
            }
        }
        // Movimiento del personaje cuando ataca hacia cada lado
        // Direccion 1 = Izquierda
        // Direccion 2 = Derecha
        // Direccion 3 = Abajo
        // Direccion 4 = Frente
        if (bAtaque){
            ataque(charPersonaje);
            switch (charPersonaje.getDir()){
                case 1:{
                    charPersonaje.setAnimacion(aniAtaI);
                    break;
                }
                case 2:{
                    charPersonaje.setAnimacion(aniAtaD);
                    break;
                }
                case 3:{
                    charPersonaje.setAnimacion(aniAtaA);
                    break;
                }
                case 4:{
                    charPersonaje.setAnimacion(aniAtaF);
                    break;
                }
            }
        }
        /*Checa la vida de los personajes elimina los que no tienen vida*/
        for (Object monstruo : arrEnemigos) {
            Character enemigo = (Character)monstruo;
            if(enemigo.getHp() <= 0) {
                enemigo.isAlive = false;
                if(enemigo.getTipo() == 3){
                    bVictoria = true;
                    bMenu = !bMenu;
                }
            }

        }
        if (charPersonaje.getHp() <= 0){
            bPerder = true;
            bMenu = !bMenu;
        }
    }

        /*
            Aggro
            La funcion esta encargada de causar que los enemigos
            y decida si es mejor moverse en el eje X o Y.
            Tambien cambia las animacion correspondientes
        */
    
    public void aggro() {
            boolean bloqueado;  //para saber si esta algo atravezado
            int distanciaEjeSec = 50;
            //cierta tolerancia en el segundo eje de comparacion
            for (Object monstruo : arrEnemigos) {
                        Character enemigo = (Character)monstruo;
                        if(Math.abs(enemigo.getX() - charPersonaje.getX()) <= 600 &&
                        Math.abs(enemigo.getY() - charPersonaje.getY()) <= 600) {

                        bloqueado = false;
                        if(enemigo.getMov()){
                            if(enemigo.getX() < charPersonaje.getX()&&Math.abs(
                                    enemigo.getY() - charPersonaje.getY())
                                    <distanciaEjeSec) {
                                for (Object monstruo2 : arrEnemigos) {
                                    Character enemigo2 = (Character)monstruo2;
                                    if(Math.abs(enemigo2.getX()
                                            - enemigo.getX())
                                            <=80 && Math.abs(enemigo2.getY() -
                                                    enemigo.getY()) <
                                            distanciaEjeSec
                                            && enemigo.getId() !=
                                            enemigo2.getId()) {
                                        
                                        //checa si hay algo atravezado
                                        if(enemigo.getX() < enemigo2.getX()) {
                                            bloqueado = true;
                                        }
                                    }
                                }
                                if(Math.abs(enemigo.getX() - charPersonaje
                                        .getX())
                                        <= 80 && Math.abs(enemigo.getY() -
                                                charPersonaje.getY())
                                        < distanciaEjeSec) {
                                    if(charPersonaje.getX() > enemigo.getX())
                                    bloqueado = true;
                                }
                                
                                            for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getX() <= bloque.getX()&&
                                                        Math.abs(enemigo.getX() - bloque.getX()) <= distanciaProxPrin + 100
                                                        && Math.abs(enemigo.getY() - bloque.getY())<=distanciaProxSec + 100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }

                                    if(!bloqueado) {
                                        enemigo.setX(enemigo.getX()
                                                + enemigo.getSpeed());
                                        if (enemigo.getTipo() == 1)
                                            enemigo.setAnimacion(aniMovDMalo);
                                        else if (enemigo.getTipo() == 2)
                                            enemigo.setAnimacion(aniMovDMalo2);
                                        else
                                            enemigo.setAnimacion(aniMovDJefe);
                                    }

                            }
                            else if(charPersonaje.getX()<= enemigo.getX()) {
                            //si el enemigo esta a la derecha
                                if(charPersonaje.getY() <= enemigo.getY()) {
                            //y esta abajo o a la misma altura
                                    if(Math.abs(charPersonaje.getY() -
                                            enemigo.getY())
                            //si la diferencia en Y es mayora X
                                            >Math.abs(charPersonaje.getX()
                                                    - enemigo.getX()))
                                    {
                                        for (Object monstruo2 : arrEnemigos) {
                                            Character enemigo2 =
                                                    (Character)monstruo2;
                                            if(Math.abs(enemigo2.getY() -
                                                    enemigo.getY()) <=80 &&
                                                    Math.abs(enemigo2.getX()
                                                            - enemigo.getX())
                                                    < distanciaEjeSec
                                                    && enemigo.getId()
                                                    != enemigo2.getId()) {
                                                    //checa si hay algo atravezado
                                                if(enemigo.getY()
                                                        > enemigo2.getY()) {
                                                    bloqueado = true;
                                                }
                                            }
                                        }
                                        if(Math.abs(enemigo.getY()
                                                - charPersonaje.getY())
                                                <= 80 && Math.abs(enemigo.getX()
                                                        - charPersonaje.getX())
                                                < distanciaEjeSec) {
                                            if(charPersonaje.getY()
                                                    < enemigo.getY()) {
                                                bloqueado = true;
                                            }
                                        }
                                        
                                        for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getY() >= bloque.getY()&&
                                                        Math.abs(enemigo.getY() - bloque.getY()) <= distanciaProxPrin+ 100 
                                                        && Math.abs(enemigo.getX() - bloque.getX())<=distanciaProxSec+100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                        if(!bloqueado) {
                                            enemigo.setY(enemigo.getY()
                                                    - enemigo.getSpeed());
                                            //se mueve hacia abajo
                                            if (enemigo.getTipo() == 1)
                                                enemigo.setAnimacion
                                                        (aniMovAMalo);
                                            else if (enemigo.getTipo() == 2)
                                                enemigo.setAnimacion
                                                        (aniMovAMalo2);
                                            else
                                                enemigo.setAnimacion
                                                        (aniMovAJefe);
                                        }
                                        //aqui se manda el paquete al servidor
                                    }
                                    else {
                                        for (Object monstruo2 : arrEnemigos) {
                                            Character enemigo2 =
                                                    (Character)monstruo2;
                                            if(Math.abs(enemigo2.getX()
                                                    - enemigo.getX())
                                                    <=80 && Math.abs
                                                            (enemigo2.getY()
                                                            - enemigo.getY())
                                                    < distanciaEjeSec
                                                    && enemigo.getId()
                                                    != enemigo2.getId()) {
                                                    //checa si hay algo atravezado
                                                if(enemigo.getX()
                                                        > enemigo2.getX()) {
                                                    bloqueado = true;
                                                }
                                            }
                                        }
                                        if(Math.abs(enemigo.getX()
                                                - charPersonaje.getX())
                                                <= 80 && Math.abs(enemigo.getY()
                                                        - charPersonaje.getY())
                                                < distanciaEjeSec) {
                                            if(enemigo.getX()>charPersonaje
                                                    .getX()) {
                                                bloqueado = true;
                                            }
                                        }
                                        
                                        for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getX() >= bloque.getX()&&
                                                        Math.abs(enemigo.getX() - bloque.getX()) <= distanciaProxPrin + 100
                                                        && Math.abs(enemigo.getY() - bloque.getY())<=distanciaProxSec + 100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                        
                                        if(!bloqueado) {
                                            enemigo.setX(enemigo.getX()
                                                    - enemigo.getSpeed());
                                            if (enemigo.getTipo() == 1)
                                                enemigo.setAnimacion
                                                        (aniMovIMalo);
                                            else if (enemigo.getTipo() == 2)
                                                enemigo.setAnimacion
                                                        (aniMovIMalo2);
                                            else
                                                enemigo.setAnimacion
                                                        (aniMovIJefe);
                                        }
                                        //aqui se manda el paquete
                                    }

                                }
                                else { // o esta arriba
                                    if(Math.abs(charPersonaje.getY()
                                            - enemigo.getY())
                                            //si la diferencia en Y es mayora X
                                                >Math.abs(charPersonaje.getX()
                                                        - enemigo.getX()))
                                        {
                                            for (Object monstruo2 : arrEnemigos)
                                            {
                                                Character enemigo2 =
                                                        (Character)monstruo2;
                                                if(Math.abs(enemigo2.getY()
                                                        - enemigo.getY()) <=
                                                        80 && Math.abs(
                                                        enemigo2.getX() -
                                                        enemigo.getX())
                                                        < distanciaEjeSec
                                                        && enemigo.getId()
                                                        != enemigo2.getId()) {
                                                        //checa si hay algo atravezado
                                                    if(enemigo.getY()
                                                            < enemigo2.getY()) {
                                                        bloqueado = true;
                                                    }
                                                }
                                            }
                                            if(Math.abs(enemigo.getY()
                                                    - charPersonaje.getY())
                                                    <= 80 && Math.abs
                                                            (enemigo.getX()
                                                            - charPersonaje.
                                                            getX())
                                                    < distanciaEjeSec) {
                                                if(enemigo.getY()<charPersonaje
                                                        .getY()) {
                                                    bloqueado = true;
                                                }
                                            }
                                            
                                            for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getY() <= bloque.getY()&&
                                                        Math.abs(enemigo.getY() - bloque.getY()) <= distanciaProxPrin  + 100
                                                        && Math.abs(enemigo.getX() - bloque.getX())<=distanciaProxSec + 100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                            
                                            
                                            if(!bloqueado) {
                                                enemigo.setY(enemigo.getY()
                                                        + enemigo.getSpeed());
                                                if (enemigo.getTipo() == 1)
                                                    enemigo.setAnimacion
                                                            (aniMovFMalo);
                                                else if (enemigo.getTipo() == 2)
                                                     enemigo.setAnimacion
                                                            (aniMovFMalo2);
                                                else
                                                    enemigo.setAnimacion
                                                            (aniMovFJefe);
                                            }
                                            //aqui se manda el paquete al servidor
                                        }
                                        else {

                                        for (Object monstruo2 : arrEnemigos) {
                                            Character enemigo2 =
                                                    (Character)monstruo2;
                                            if(Math.abs(enemigo2.getX()
                                                    - enemigo.getX())
                                                    <=80 && Math.abs(enemigo2
                                                            .getY()
                                                            - enemigo.getY())
                                                    < distanciaEjeSec
                                                    && enemigo.getId()
                                                    != enemigo2.getId()) {
                                                //checa si hay algo atravezado
                                                if(enemigo.getX() > enemigo2
                                                        .getX()) {
                                                    bloqueado = true;
                                                }
                                            }
                                        }
                                        if(Math.abs(enemigo.getX()
                                                - charPersonaje.getX())
                                                <= 80 && Math.abs(enemigo.getY()
                                                        - charPersonaje.getY())
                                                < distanciaEjeSec) {
                                            if(enemigo.getX()>charPersonaje
                                                    .getX()) {
                                                bloqueado = true;
                                            }
                                        }
                                        
                                        for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getX() >= bloque.getX()&&
                                                        Math.abs(enemigo.getX() - bloque.getX()) <= distanciaProxPrin + 100
                                                        && Math.abs(enemigo.getY() - bloque.getY())<=distanciaProxSec + 100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                        
                                        if(!bloqueado) {
                                            enemigo.setX(enemigo.getX()
                                                    - enemigo.getSpeed());
                                            if (enemigo.getTipo() == 1)
                                                enemigo.setAnimacion
                                                        (aniMovIMalo);
                                            else if (enemigo.getTipo() == 2)
                                                 enemigo.setAnimacion
                                                        (aniMovIMalo2);
                                            else
                                                enemigo.setAnimacion
                                                        (aniMovIJefe);
                                        }
                                            //aqui se manda el paquete
                                        }
                                }
                            }
                            else { //si esta a la izquierda
                                if(charPersonaje.getY()
                                        <= enemigo.getY()) {
                                    //y esta abajo
                                    if(Math.abs(charPersonaje.getY()
                                            - enemigo.getY())
                                    //si la diferencia en Y es mayora X
                                            <Math.abs(charPersonaje.getX()
                                                    - enemigo.getX()))
                                    {
                                        
                                        for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getY() >= bloque.getY()&&
                                                        Math.abs(enemigo.getY() - bloque.getY()) <= distanciaProxPrin + 100
                                                        && Math.abs(enemigo.getX() - bloque.getX())<=distanciaProxSec+100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                        
                                        if(!bloqueado) {
                                        enemigo.setY(enemigo.getY()
                                                - enemigo.getSpeed());
                                        if (enemigo.getTipo() == 1)
                                            enemigo.setAnimacion(aniMovAMalo);
                                        else if (enemigo.getTipo() == 2)
                                            enemigo.setAnimacion
                                                   (aniMovAMalo2);
                                       else
                                           enemigo.setAnimacion
                                                   (aniMovAJefe);
                                    }
                                        //aqui se manda el paquete al servidor
                                    }
                                    else {
                                        
                                        for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getX() <= bloque.getX()&&
                                                        Math.abs(enemigo.getX() - bloque.getX()) <= distanciaProxPrin+100 
                                                        && Math.abs(enemigo.getY() - bloque.getY())<=distanciaProxSec+100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                        if(!bloqueado) {
                                        enemigo.setX(enemigo.getX()
                                                + enemigo.getSpeed());
                                        if (enemigo.getTipo() == 1)
                                            enemigo.setAnimacion(aniMovDMalo);
                                        else if (enemigo.getTipo() == 2)
                                             enemigo.setAnimacion
                                                    (aniMovDMalo2);
                                        else
                                            enemigo.setAnimacion
                                                    (aniMovDJefe);
                                        //aqui se manda el paquete
                                        }
                                    }
                                }
                                else { // o esta arriba
                                    if(Math.abs(charPersonaje.getY()
                                            - enemigo.getY())
                                        //si la diferencia en Y es mayora X
                                                <Math.abs(charPersonaje.getX()
                                                        - enemigo.getX()))
                                        {
                                            
                                            for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getY() <= bloque.getY()&&
                                                        Math.abs(enemigo.getY() - bloque.getY()) <= distanciaProxPrin 
                                                        && Math.abs(enemigo.getX() - bloque.getX())<=distanciaProxSec) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                            if(!bloqueado){
                                            enemigo.setY(enemigo.getY()
                                                    + enemigo.getSpeed());
                                            if (enemigo.getTipo() == 1)
                                                enemigo.setAnimacion
                                                        (aniMovFMalo);
                                            else if (enemigo.getTipo() == 2)
                                                 enemigo.setAnimacion
                                                        (aniMovFMalo2);
                                            else
                                                enemigo.setAnimacion
                                                        (aniMovFJefe);
                                            }
                                            //aqui se manda el paquete al servidor
                                        }
                                        else {
                                        
                                        for (Object tile : map) {
                                                Terrain bloque = (Terrain)tile;
                                                if(!bloque.getIsWalkable() &&enemigo.getX() <= bloque.getX()&&
                                                        Math.abs(enemigo.getX() - bloque.getX()) <= distanciaProxPrin +100
                                                        && Math.abs(enemigo.getY() - bloque.getY())<=distanciaProxSec + 100) {
                                                    bloqueado = true;
                                                    break;
                                                }
                                            }
                                            enemigo.setX(enemigo.getX()
                                                    + enemigo.getSpeed());
                                            if (enemigo.getTipo() == 1)
                                                enemigo.setAnimacion
                                                        (aniMovDMalo);
                                            else if (enemigo.getTipo() == 2)
                                                 enemigo.setAnimacion
                                                        (aniMovDMalo2);
                                            else
                                                enemigo.setAnimacion
                                                        (aniMovDJefe);
                                            //aqui se manda el paquete
                                        }
                                }
                            }
                        }
                        }
                    }

        }
        /*
            Detecta en que direccion esta volteando en personaje
            y causa da;o al enemigo adyacente en esa direccion.
            le causara da;o y lo empujara
        */
    public void ataque(Character c) {
        boolean empujarBloqueado;
        boolean bAtacado;
        if(c.getAnimacion() == aniMovI || c.getAnimacion()
               == aniMovIMalo || c.getAnimacion() == aniMovIMalo2
               ||c.getAnimacion() == aniMovIE||c.getAnimacion() == aniMovIJefe)
       {
           if(c.isPlayable == true) {
               //si el jugador esta atacando
               for (Object monstruo : arrEnemigos) {
               //se buscara a los enemigos
                   empujarBloqueado = false;
                   bAtacado = false;
                       Character enemigo = (Character)monstruo;
                       if(c.getX() - enemigo.getX() <= distanciaAtaqueX
                               && Math.abs(enemigo.getY() - c.getY())
                               <=distanciaAtaqueY && c.getX()
                               > enemigo.getX()) {
                           //si esta en distancia de ataque
                           if(!bAtacado) {
                            enemigo.setHp(enemigo.getHp() - 25);
                            bAtacado = true;
                            if (enemigo.getHp() <= 0){
                                empujarBloqueado = true;
                            }
                           }
                           //se le causara da;o
                           for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getX() <=
                                        charPersonaje.getX() && Math.abs(enemigo.getX()-distanciaEmpujonChar - bloque.getX())<=100 &&
                                        Math.abs(bloque.getY() - enemigo.getY()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                           }
                           if(!empujarBloqueado){
                            iImpactX = charPersonaje.getX();
                            iImpactY = charPersonaje.getY();
                            bFisica1 = true;
                            enemigo.setX(enemigo.getX() - distanciaEmpujonChar);
                            //y sera empujado
                           }
                           break;
                       }
               }
           }
           else{       //si un enemigo esta atacando
               if(c.getX() - charPersonaje.getX() <= distanciaEneAtaqueX
                       && Math.abs(charPersonaje.getY()
                               - c.getY())<=distanciaEneAtaqueX) {
                       //y el jugador esta a distancia
                   empujarBloqueado = false;
                   charPersonaje.setHp(charPersonaje.getHp() - 10);
                        //se le causara da;o
                    if (c.getTipo() == 1)
                       c.setAnimacion(aniAtaIMalo);
                    else if (c.getTipo() == 2)
                       c.setAnimacion(aniAtaIMalo2);
                    else if (c.getTipo() == 3)
                       c.setAnimacion(aniAtaIJefe);
                   c.setMov(false);
                   for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getX() <=
                                        c.getX() && Math.abs(charPersonaje.getX()-distanciaEmpujonChar - bloque.getX())<=100 &&
                                        Math.abs(bloque.getY() - c.getY()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                    }
                   if(!empujarBloqueado){
                    for (Object monstruo : arrEnemigos) {   //se buscara a los enemigos
                        Character enemigo = (Character)monstruo;
                        iImpactX = charPersonaje.getX();
                        iImpactY = charPersonaje.getY();
                        bFisica1 = true;
                        enemigo.setX(enemigo.getX() + distanciaEmpujonEne); //y seran empujados
                    }

                    for (Object tile : map) {
                        Terrain bloque = (Terrain)tile;
                        bloque.setX(bloque.getX() + distanciaEmpujonEne);
                    }
                   }
               }
           }

       }
       else if(c.getAnimacion() == aniMovD || c.getAnimacion() ==
               aniMovDMalo || c.getAnimacion()
               == aniMovDMalo2 ||c.getAnimacion() == aniMovDE ||
               c.getAnimacion() == aniMovDJefe) {
           if(c.isPlayable == true) {
               //si el jugador esta atacando
               for (Object monstruo : arrEnemigos) {
               //se buscara a los enemigos
                   empujarBloqueado = false;
                   bAtacado = false;
                       Character enemigo = (Character)monstruo;
                       if( enemigo.getX() - c.getX() <= distanciaAtaqueX
                               && Math.abs(enemigo.getY() - c.getY())
                               <=distanciaAtaqueY && enemigo.getX()
                               > c.getX()) {
                           //si esta en distancia de ataque
                           if(!bAtacado) {
                            enemigo.setHp(enemigo.getHp() - 25);
                            bAtacado = true;
                            if (enemigo.getHp() <= 0){
                                empujarBloqueado = true;
                            }
                            //se le causara da;o
                           }
                           for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getX() >=
                                        charPersonaje.getX() && Math.abs(enemigo.getX()+distanciaEmpujonChar - bloque.getX())<=100 &&
                                        Math.abs(bloque.getY() - enemigo.getY()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                           }
                           if(!empujarBloqueado) {
                                iImpactX = charPersonaje.getX();
                                iImpactY = charPersonaje.getY();
                                bFisica1 = true;
                                enemigo.setX(enemigo.getX() + distanciaEmpujonChar);
                               //y sera empujado
                           }
                           break;
                       }
               }
           }
           else{

//si un enemigo esta atacando
               if(charPersonaje.getX() - c.getX() <= distanciaEneAtaqueX
                       && Math.abs(charPersonaje.getY() - c.getY())
                       <=distanciaEneAtaqueX) {
                       //y el jugador esta a distancia
                   empujarBloqueado = false;
                   charPersonaje.setHp(charPersonaje.getHp() - 10);
                       //se le causara da;o
                   c.setMov(false);
                   for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getX() >=
                                        charPersonaje.getX() && Math.abs(charPersonaje.getX()+distanciaEmpujonEne - bloque.getX())<=100 &&
                                        Math.abs(bloque.getY() - c.getY()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                    System.out.println("avtiv");
                                }
                    }
                    if (c.getTipo() == 1)
                       c.setAnimacion(aniAtaDMalo);
                    else if (c.getTipo() == 2)
                       c.setAnimacion(aniAtaDMalo2);
                    else if (c.getTipo() == 3)
                       c.setAnimacion(aniAtaDJefe);
                   if(!empujarBloqueado){
                    for (Object monstruo : arrEnemigos) {
                        //se buscara a los enemigos
                        Character enemigo = (Character)monstruo;
                        iImpactX = charPersonaje.getX();
                        iImpactY = charPersonaje.getY();
                        bFisica1 = true;
                        enemigo.setX(enemigo.getX() - distanciaEmpujonChar);
                        //y seran empujados
                    }

                   for (Object tile : map) {
                               Terrain bloque = (Terrain)tile;
                               bloque.setX(bloque.getX() - distanciaEmpujonChar);
                   }
                   }
               }
           }

       }
       else if(c.getAnimacion() == aniMovA || c.getAnimacion() ==
               aniMovAMalo || c.getAnimacion() == aniMovAMalo2
               ||c.getAnimacion() == aniMovAE ||c.getAnimacion() == aniMovAJefe)
       {
           if(c.isPlayable == true) {
               //si el jugador esta atacando
               for (Object monstruo : arrEnemigos) {
               //se buscara a los enemigos
                       Character enemigo = (Character)monstruo;
                       bAtacado = false;
                       empujarBloqueado = false;
                       if(c.getY() - enemigo.getY() <= distanciaAtaqueX
                               && Math.abs(enemigo.getX()
                                       - c.getX())<=distanciaAtaqueY
                               && c.getY() > enemigo.getY()) {
                           //si esta en distancia de ataque
                           for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getY() >=
                                        charPersonaje.getY() && Math.abs(enemigo.getY()+distanciaEmpujonChar - bloque.getY())<=100 &&
                                        Math.abs(bloque.getX() - c.getX()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                    }
                           if(!bAtacado) {
                                enemigo.setHp(enemigo.getHp() - 25);
                                bAtacado = true;
                                if (enemigo.getHp() <= 0){
                                empujarBloqueado = true;
                            }
                           }
                           //se le causara da;os
                            if(!empujarBloqueado) {
                                iImpactX = charPersonaje.getX();
                                iImpactY = charPersonaje.getY();
                                bFisica1 = true;
                                enemigo.setY(enemigo.getY() - distanciaEmpujonChar);
                           }
                               //y sera empujado
                           break;
                       }
               }
           }
           else{       //si un enemigo esta atacando
               if(c.getY() - charPersonaje.getY() <= distanciaEneAtaqueX
                           && Math.abs(charPersonaje.getX()
                                   - c.getX())<=distanciaEneAtaqueX) {
                   empujarBloqueado = false;
                           //y el jugador esta a distancia
                   charPersonaje.setHp(charPersonaje.getHp() - 10);
                           //se le causara da;o
                   for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getY() <=
                                        c.getY() && Math.abs(charPersonaje.getY()-distanciaEmpujonEne - bloque.getY())<=100 &&
                                        Math.abs(bloque.getX() - c.getX()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                    }

                   c.setMov(false);
                    if (c.getTipo() == 1)
                       c.setAnimacion(aniAtaAMalo);
                    else if (c.getTipo() == 2)
                      c.setAnimacion(aniAtaAMalo2);
                    else if (c.getTipo() == 3)
                      c.setAnimacion(aniAtaAJefe);
                   if(!empujarBloqueado) {
                   for (Object monstruo : arrEnemigos) {
                   //se buscara a los enemigos
                       Character enemigo = (Character)monstruo;
                        iImpactX = charPersonaje.getX();
                        iImpactY = charPersonaje.getY();
                        bFisica1 = true;
                       enemigo.setY(enemigo.getY() + distanciaEmpujonEne); //y seran empujados
                   }
                   for (Object tile : map) {
                               Terrain bloque = (Terrain)tile;
                                iImpactX = charPersonaje.getX();
                                iImpactY = charPersonaje.getY();
                                bFisica1 = true;
                               bloque.setY(bloque.getY() + distanciaEmpujonEne);
                           }
                   }
               }
           }

       }

       if(c.getAnimacion() == aniMovF || c.getAnimacion() == aniMovFMalo
               || c.getAnimacion() == aniMovFMalo2 ||
               c.getAnimacion() == aniMovFE || c.getAnimacion() == aniMovFJefe )
       {
           if(c.isPlayable == true) {
               //si el jugador esta atacando
               for (Object monstruo : arrEnemigos) {
                   empujarBloqueado = false;
                   bAtacado = false;
               //se buscara a los enemigos
                       Character enemigo = (Character)monstruo;
                       if( enemigo.getY() - c.getY() <= distanciaAtaqueX
                               && Math.abs(enemigo.getX() - c.getX())
                               <=distanciaAtaqueY && enemigo.getY()
                               > charPersonaje.getY()) {
                               //si esta en distancia de ataque
                           for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getY() >=
                                        charPersonaje.getY() && Math.abs(enemigo.getY()+distanciaEmpujonEne - bloque.getY())<=100 &&
                                        Math.abs(bloque.getX() - c.getX()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                    }
                           if(!bAtacado){
                                enemigo.setHp(enemigo.getHp() - 25);
                                bAtacado = true;
                            if (enemigo.getHp() <= 0){
                                empujarBloqueado = true;
                            }
                           //se le causara da;o
                           }
                           if(!empujarBloqueado) {
                                iImpactX = charPersonaje.getX();
                                iImpactY = charPersonaje.getY();
                                bFisica1 = true;
                                enemigo.setY(enemigo.getY() + distanciaEmpujonChar);
                                //y sera empujado
                           }

                           break;
                       }
               }
           }
           else{       //si un enemigo esta atacando
               if(charPersonaje.getY() - c.getY() <= distanciaEneAtaqueX
                       && Math.abs(charPersonaje.getY() - c.getY())
                       <=distanciaEneAtaqueX) {
                       //y el jugador esta a distancia
                   empujarBloqueado = false;
                   charPersonaje.setHp(charPersonaje.getHp() - 10);
                   //se le causara da;o
                   for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                if(!bloque.getIsWalkable() && bloque.getY() >=
                                        c.getY() && Math.abs(charPersonaje.getY()+distanciaEmpujonEne - bloque.getY())<=100 &&
                                        Math.abs(bloque.getX() - c.getX()) <= distanciaProxPrin) {
                                    empujarBloqueado = true;
                                }
                    }
                   c.setMov(false);
                    if (c.getTipo() == 1)
                        c.setAnimacion(aniAtaFMalo);
                    else if (c.getTipo() == 2)
                        c.setAnimacion(aniAtaFMalo2);
                    else if (c.getTipo() == 3)
                        c.setAnimacion(aniAtaFJefe);
                if(!empujarBloqueado) {
                    for (Object monstruo : arrEnemigos) {
                        //se buscara a los enemigos
                        Character enemigo = (Character)monstruo;
                        iImpactX = charPersonaje.getX();
                        iImpactY = charPersonaje.getY();
                        bFisica1 = true;
                        enemigo.setY(enemigo.getY() - distanciaEmpujonEne);
                        //y seran empujados
                    }
                    for (Object tile : map) {
                                Terrain bloque = (Terrain)tile;
                                bloque.setY(bloque.getY() - distanciaEmpujonEne);
                    }
                }
               }
           }

       }
    }

     /*
        Esta funcion determina cundo se llama la funcion ataque
        de los enemigos dependiendo que que tan lejos estan
        del jugador.
     */

    // Lee cuando existe combate entre personaje y enemigos
    void enemigoCombate() {
        if(tiempoDAtaque > 10) {
            for (Object monstruo : arrEnemigos) {
                Character enemigo = (Character)monstruo;
                if(Math.abs(charPersonaje.getX() -
                        enemigo.getX()) <= distanciaEneAtaqueX
                        &&  Math.abs(charPersonaje.getY() -
                                enemigo.getY()) <= distanciaEneAtaqueX) {
                    ataque(enemigo);
                    tiempoDAtaque = 0;
                }
            }
        }
    }

    public void checaColision(){
        // Si el principal choca con el npc
        for (Object arrnpc : arrNpcs) {
            Character npc = (Character)arrnpc;
            if (npc.colisiona(charPersonaje)){
                    bMensaje1 = true;
            }
            else
                bMensaje1 = false;
        }
    }

            /**
         * update
         *
         * Metodo sobrescrito de la clase <code>Applet</code>,
         * heredado de la clase Container.<P>
         * En este metodo lo que hace es actualizar el contenedor y
         * define cuando usar ahora el paint
         * @param graGrafico es el <code>objeto grafico</code> usado para dibujar.
         *
         */
    public void paint (Graphics graGrafico){
        // Inicializan el DoubleBuffer
        if (imaImagenApplet == null){
            imaImagenApplet = createImage (this.getSize().width,
                    this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics();
        }
        Image imaBack;

        //el fondo que se escoge depende del estado de la variable bMenu y bLab
        if (bPerder){
            URL urlImageBack = this.getClass().getResource("moriste.png");
            imaBack = Toolkit.getDefaultToolkit().
                    getImage(urlImageBack);
        }
        else{
            if(bVictoria){
                URL urlImageBack = this.getClass().getResource("Ganaste.png");
                imaBack = Toolkit.getDefaultToolkit().
                        getImage(urlImageBack);
            }
            else{
                if(!bMenu) {
                URL urlImageBack = this.getClass().getResource("we.png");
                    imaBack = Toolkit.getDefaultToolkit().
                        getImage(urlImageBack);
                }

                else {
                    if(bCargar){
                        URL urlImageBack = this.getClass().getResource("menu1.png");
                        imaBack = Toolkit.getDefaultToolkit().
                                getImage(urlImageBack);
                    }
                    else if (bGuardar){
                        URL urlImageBack = this.getClass().getResource("menu2.png");
                        imaBack = Toolkit.getDefaultToolkit().
                                getImage(urlImageBack);
                    }
                    else if (bInstrucciones){
                        URL urlImageBack = this.getClass().getResource("menu4.png");
                        imaBack = Toolkit.getDefaultToolkit().
                                getImage(urlImageBack);
                    }
                    else if (bExit){
                        URL urlImageBack = this.getClass().getResource("menu5.png");
                        imaBack = Toolkit.getDefaultToolkit().
                                getImage(urlImageBack);
                    }
                    else if (bMostrarI){
                        URL urlImageBack = this.getClass()
                                .getResource("Instrucciones.png");
                        imaBack = Toolkit.getDefaultToolkit().
                                getImage(urlImageBack);               
                    }
                    else{
                        URL urlImageBack = this.getClass().getResource("menu5.png");
                        imaBack = Toolkit.getDefaultToolkit().
                                getImage(urlImageBack);
                    }
                }
            }
        }
        // Desplegar imagen de fondo
        graGraficaApplet.drawImage(imaBack, 0, 0,
                getWidth(), getHeight(), this);

        // Actualizar el foreground
        graGraficaApplet.setColor (getForeground());
            paint1(graGraficaApplet);

        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenApplet, 0, 0, this);
    }

    /**
     * paint
     *
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada,
     * ademas que cuando la imagen es cargada te despliega una advertencia.
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     *
     */
    public void paint1(Graphics g) {
        //contadores para hacer el mapa
        int fontSize = 18;
        g.setFont(new Font("Monospaced", Font.BOLD, fontSize));
        g.setColor(Color.yellow);

        if(!bMenu){
        if(map != null && !bLab){
            for (Object tile : map) {
                Terrain bloque = (Terrain)tile;
                g.drawImage(bloque.getImg(), bloque.getX(),
                        bloque.getY(), this);
            }
        }
        else if(map == null) {
            g.drawString("NULL", 100, 100);
        }
        // Se dibujan los npc
        for (Object npcarr : arrNpcs) {
            Character npc = (Character)npcarr;
            g.drawImage(npc.getImg(),
                    npc.getX(),npc.getY(), this);
        }
        // Se dibuja el personaje principal
        g.drawImage(charPersonaje.getAnimacion().getImagen()
                , charPersonaje.getX() , charPersonaje.getY(), this);
        // Barras de vidas de los enemigos
        for (Object monstruo : arrEnemigos) {
                    Character enemigo = (Character)monstruo;
                    if(enemigo.getId() == idJefe) {
                            g.drawImage(enemigo.getAnimacion().getImagen(),
                            enemigo.getX()-250,enemigo.getY()-250, this);
                    }
                    else {
                            g.drawImage(enemigo.getAnimacion().getImagen(),
                            enemigo.getX(),enemigo.getY(), this);
                    }
                    if(enemigo.getTipo() == 1 && enemigo.getHp() > 75)
                        g.drawImage(imaVida100, enemigo.getX() + 20
                                , enemigo.getY(), this);
                   else if(enemigo.getTipo() == 1 && enemigo.getHp() <= 75 &&
                           enemigo.getHp() >50)
                                 g.drawImage(imaVida75, enemigo.getX()
                                , enemigo.getY(), this);
                   else if(enemigo.getTipo() == 1 && enemigo.getHp() <= 50 &&
                           enemigo.getHp() >25)
                                g.drawImage(imaVida50, enemigo.getX()
                                , enemigo.getY(), this);
                   else if(enemigo.getTipo() == 1 && enemigo.getHp() <= 25 &&
                           enemigo.getHp() >0)
                                g.drawImage(imaVida25, enemigo.getX()
                                , enemigo.getY(), this);
                   else if(enemigo.getTipo() == 1 && enemigo.getHp() <= 0)
                       g.drawImage(imaVida0, enemigo.getX()
                               , enemigo.getY(), this);

                    if(enemigo.getTipo() == 2 && enemigo.getHp() > 150)
                        g.drawImage(imaVida100, enemigo.getX() + 20
                                , enemigo.getY(), this);
                    else if(enemigo.getTipo() == 2 && enemigo.getHp() <= 150 &&
                            enemigo.getHp() >100)
                                  g.drawImage(imaVida75, enemigo.getX()
                                 , enemigo.getY(), this);
                    else if(enemigo.getTipo() == 2 && enemigo.getHp() <= 100 &&
                            enemigo.getHp() >50)
                                 g.drawImage(imaVida50, enemigo.getX()
                                 , enemigo.getY(), this);
                    else if(enemigo.getTipo() == 2 && enemigo.getHp() <= 50 &&
                            enemigo.getHp() >0)
                                 g.drawImage(imaVida25, enemigo.getX()
                                 , enemigo.getY(), this);
                    else if(enemigo.getTipo() == 2 && enemigo.getHp() <= 0)
                        g.drawImage(imaVida0, enemigo.getX()
                                , enemigo.getY(), this);
                    if(enemigo.getTipo() == 3 && enemigo.getHp() >= 500)
                        g.drawImage(imaVida100, enemigo.getX() + 20
                                , enemigo.getY() - 250, this);
                    else if(enemigo.getTipo() == 3 && enemigo.getHp() <= 380 &&
                            enemigo.getHp() >260)
                                  g.drawImage(imaVida75, enemigo.getX()
                                 , enemigo.getY()- 250, this);
                    else if(enemigo.getTipo() == 3 && enemigo.getHp() <= 260 &&
                            enemigo.getHp() >140)
                                 g.drawImage(imaVida50, enemigo.getX()
                                 , enemigo.getY()- 250, this);
                    else if(enemigo.getTipo() == 3 && enemigo.getHp() <=140 &&
                            enemigo.getHp() >0)
                                 g.drawImage(imaVida25, enemigo.getX()
                                 , enemigo.getY()- 250, this);
                    else if(enemigo.getTipo() == 2 && enemigo.getHp() <= 0)
                        g.drawImage(imaVida0, enemigo.getX()
                                , enemigo.getY()- 250, this);
                }

        // Se dibujan los npc en el mapa
        for (Object arrnpc : arrNpcs) {
                Character npc = (Character)arrnpc;
            if (bMensaje1 && npc.getId() == 0){
                g.drawString("Somos de los ultimos sobrevivientes de la tierra.",
                        npc.getX() - npc.getAncho(), npc.getY()-90);
                g.drawString("Es tu trabajo encontrar al insecto mutante padre",
                        npc.getX() - npc.getAncho(), npc.getY()-60);
                g.drawString("y destruirlo para que todo vuelva a la normalidad",
                        npc.getX() - npc.getAncho(), npc.getY()-30);
                g.drawString("Dirigete al ESTE!!!",
                        npc.getX() - npc.getAncho(), npc.getY());
            }
        }

        // Barra de vida del personaje principal
        if(charPersonaje.getHp() > 75)
             g.drawImage(imaVida100, charPersonaje.getX()
                     , charPersonaje.getY(), this);
        else if(charPersonaje.getHp() <= 75 && charPersonaje.getHp() >50)
             g.drawImage(imaVida75, charPersonaje.getX()
                     , charPersonaje.getY(), this);
        else if(charPersonaje.getHp() <= 50 && charPersonaje.getHp() >25)
            g.drawImage(imaVida50, charPersonaje.getX()
                    , charPersonaje.getY(), this);
        else if(charPersonaje.getHp() <= 25 && charPersonaje.getHp() >0)
             g.drawImage(imaVida25, charPersonaje.getX()
                     , charPersonaje.getY(), this);
        else if(charPersonaje.getHp() <= 0)
            g.drawImage(imaVida0, charPersonaje.getX()
                    , charPersonaje.getY(), this);
        g.setColor(Color.red);
        g.setFont(new Font("Dialog", Font.BOLD, fontSize));
        // Dibujar mensajes de fisica
        if (bFisica1){
            g.drawString("F1 = -F2 / F=ma", 500, 500);
        }
        if (iContPots >= 1)
            g.drawImage(imaPotion, 20, 40,this);
        if (iContPots >= 2)
            g.drawImage(imaPotion, 40, 40,this);
        if(iContPots >= 3)
            g.drawImage(imaPotion, 60, 40,this);

    //                for (Object encBloque : encBloques) {
    //                    Entidad bloque = (Entidad)encBloque;
    //                    g.drawImage(bloque.getImagen(), bloque.getX(),
    //                            bloque.getY(), this);
    //
        }
        else{
            if (!bVictoria && !bPerder){
                g.setColor(Color.white);
                g.setFont(new Font("Dialog", Font.BOLD, fontSize));
                g.drawString("Presiona 'M' para jugar ", 700, 500);
            }       
        }
    }

    @Override
    public void keyTyped(KeyEvent ex) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Acciones de cuando las teclas se presionan
        if (e.getKeyCode() == KeyEvent.VK_A){
            bMovimiento = true;
            charPersonaje.setDir(1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            bMovimiento = true;
            charPersonaje.setDir(2);
        }
        

        else if (e.getKeyCode() == KeyEvent.VK_J){
            if (charPersonaje.getHp() != 100)
                if (iContPots > 0){
                    charPersonaje.setHp(100);
                    iContPots--;
                }
        }
        else if (e.getKeyCode() == KeyEvent.VK_X){
            if(bVictoria || bPerder)
                System.exit(0);
        }        
        else if (e.getKeyCode() == KeyEvent.VK_W){
            bMovimiento = true;
            charPersonaje.setDir(3);
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            bMovimiento = true;
            charPersonaje.setDir(4);
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (bMovimiento == false  && contadorAtaqueMain >0  ) {
                bAtaque = true;
                contadorAtaqueMain = 0;
                soundAtaque.play();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_M) {
                bMenu = !bMenu;
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_0) {
                charPersonaje.setSpeed(20);
                charPersonaje.setHp(2000);
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_R) {
            if(bPerder){
                try{
                    bPerder = false;
                    bMenu = false;
                    leeArchivoInicial();
                }catch(IOException p) {
                    System.err.println("error cargando el juego");
                }    
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (bMenu){
                if (bCargar){
                    bCargar = false;
                    bGuardar = true;
                }
                else if (bGuardar){
                    bGuardar = false;
                    bInstrucciones = true;
                }
                else if(bInstrucciones){
                    bInstrucciones = false;
                    bExit = true;
                }
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (bMenu){
                if (bGuardar){
                   bGuardar = false;
                   bCargar = true;
                }
                else if (bInstrucciones){
                    bInstrucciones = false;
                    bGuardar = true;
                }
                else if(bExit){
                    bExit = false;
                    bInstrucciones = true;
                }
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (bMenu){
                if (bCargar){
                    try{
                        leeArchivo();
                    }catch(IOException p) {
                        System.err.println("error cargando el juego");
                    }
                    bMenu = !bMenu;
                }
                else if (bGuardar){
                    if (bInicio){
                        try{
                            grabarJuego();
                        }catch(IOException p) {
                            System.err.println("error grabando el juego");
                        }
                        bMenu = !bMenu;
                    }
                }
                else if (bInstrucciones){
                    bMostrarI = true;
                    bInstrucciones = false;
                }
                else if(bExit){
                    System.exit(0);
                }
                else if (bMostrarI){
                    bMostrarI = false;
                    bInstrucciones = true;
                }
            }
        }             
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // Acciones de cuando se suelta una tecla
        bMovimiento = false;
        bAtaque = false;
        iContAni = 0;
    }


    public void leeArchivo() throws IOException {

                BufferedReader fileIn;
                String nombreArchivo = "saveFile.txt";
                fileIn = new BufferedReader(new FileReader(nombreArchivo));

                    String dato = fileIn.readLine();
                    charPersonaje.setX(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setY(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setHp(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setSpeed(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setDir(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    boolean data = true;
                        if(dato.equals("false")) {
                            data = false;
                        }
                    charPersonaje.setIsAlive(data);

                    for (Object monstruo : arrEnemigos) {
                        Character enemigo = (Character)monstruo;

                        dato = fileIn.readLine();
                        enemigo.setX(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setY(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setHp(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setSpeed(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setDir(Integer.valueOf(dato));

                        dato = fileIn.readLine();

                         data = true;
                        if(dato.equals("false")) {
                            data = false;
                        }
                        enemigo.setIsAlive(data);

                        dato = fileIn.readLine();

                        if(dato.equals("false")) {
                            data = false;
                        }
                        else {
                        data = true;
                        }
                        enemigo.setMov(data);

                    }

                for (Object personaje : arrNpcs) {
                        Character npc = (Character)personaje;
                        dato = fileIn.readLine();
                        npc.setX(Integer.valueOf(dato));
                        dato = fileIn.readLine();
                        npc.setY(Integer.valueOf(dato));

                    }


                for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    dato = fileIn.readLine();
                    bloque.setX(Integer.valueOf(dato));
                    dato = fileIn.readLine();
                    bloque.setY(Integer.valueOf(dato));

                }
                dato = fileIn.readLine();
                iContPots = Integer.valueOf(dato);
                fileIn.close();
        }

        public void grabarJuego() throws IOException {
            String nombreArchivo = "saveFile.txt";
            PrintWriter fileOut = null;
            try{
                fileOut = new PrintWriter(new FileWriter(nombreArchivo));
                fileOut.println(charPersonaje.getX());
                fileOut.println(charPersonaje.getY());
                fileOut.println(charPersonaje.getHp());
                fileOut.println(charPersonaje.getSpeed());
                fileOut.println(charPersonaje.getDir());
                fileOut.println(charPersonaje.getIsAlive());

            for (Object monstruo : arrEnemigos) {
                Character enemigo = (Character)monstruo;
                fileOut.println(enemigo.getX());
                fileOut.println(enemigo.getY());
                fileOut.println(enemigo.getHp());
                fileOut.println(enemigo.getSpeed());
                fileOut.println(enemigo.getDir());
                fileOut.println(enemigo.getIsAlive());
                fileOut.println(enemigo.getMov());

            }

            for (Object personaje : arrNpcs) {
                Character npc = (Character)personaje;
                fileOut.println(npc.getX());
                fileOut.println(npc.getY());

            }

            for (Object tile : map) {
                Terrain bloque = (Terrain)tile;;
                fileOut.println(bloque.getX());
                fileOut.println(bloque.getY());

            }
            fileOut.println(iContPots);


            }catch(IOException e) {
                System.err.println("no se encontro el archivo para guardar");
            }




            fileOut.close();
        }
        public void grabarJuegoInicial() throws IOException {
            String nombreArchivo = "saveFileI.txt";
            PrintWriter fileOut = null;
            try{
                fileOut = new PrintWriter(new FileWriter(nombreArchivo));
                fileOut.println(charPersonaje.getX());
                fileOut.println(charPersonaje.getY());
                fileOut.println(charPersonaje.getHp());
                fileOut.println(charPersonaje.getSpeed());
                fileOut.println(charPersonaje.getDir());
                fileOut.println(charPersonaje.getIsAlive());

            for (Object monstruo : arrEnemigos) {
                Character enemigo = (Character)monstruo;
                fileOut.println(enemigo.getX());
                fileOut.println(enemigo.getY());
                fileOut.println(enemigo.getHp());
                fileOut.println(enemigo.getSpeed());
                fileOut.println(enemigo.getDir());
                fileOut.println(enemigo.getIsAlive());
                fileOut.println(enemigo.getMov());

            }

            for (Object personaje : arrNpcs) {
                Character npc = (Character)personaje;
                fileOut.println(npc.getX());
                fileOut.println(npc.getY());

            }

            for (Object tile : map) {
                Terrain bloque = (Terrain)tile;;
                fileOut.println(bloque.getX());
                fileOut.println(bloque.getY());

            }
            fileOut.println(iContPots);


            }catch(IOException e) {
                System.err.println("no se encontro el archivo para guardar");
            }




            fileOut.close();
        }
        public void leeArchivoInicial() throws IOException {

                BufferedReader fileIn;
                String nombreArchivo = "saveFileI.txt";
                fileIn = new BufferedReader(new FileReader(nombreArchivo));

                    String dato = fileIn.readLine();
                    charPersonaje.setX(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setY(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setHp(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setSpeed(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    charPersonaje.setDir(Integer.valueOf(dato));

                    dato = fileIn.readLine();
                    boolean data = true;
                        if(dato.equals("false")) {
                            data = false;
                        }
                    charPersonaje.setIsAlive(data);

                    for (Object monstruo : arrEnemigos) {
                        Character enemigo = (Character)monstruo;

                        dato = fileIn.readLine();
                        enemigo.setX(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setY(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setHp(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setSpeed(Integer.valueOf(dato));

                        dato = fileIn.readLine();
                        enemigo.setDir(Integer.valueOf(dato));

                        dato = fileIn.readLine();

                         data = true;
                        if(dato.equals("false")) {
                            data = false;
                        }
                        enemigo.setIsAlive(data);

                        dato = fileIn.readLine();

                        if(dato.equals("false")) {
                            data = false;
                        }
                        else {
                        data = true;
                        }
                        enemigo.setMov(data);

                    }

                for (Object personaje : arrNpcs) {
                        Character npc = (Character)personaje;
                        dato = fileIn.readLine();
                        npc.setX(Integer.valueOf(dato));
                        dato = fileIn.readLine();
                        npc.setY(Integer.valueOf(dato));

                    }


                for (Object tile : map) {
                    Terrain bloque = (Terrain)tile;
                    dato = fileIn.readLine();
                    bloque.setX(Integer.valueOf(dato));
                    dato = fileIn.readLine();
                    bloque.setY(Integer.valueOf(dato));

                }
                dato = fileIn.readLine();
                iContPots = Integer.valueOf(dato);
                fileIn.close();
        }
        


        /*
            Esta funcion lee un archivo de texto y crea un arreglo que contiene
            los tiles que forman el mapa.
        */
    public void creaMapa(int mapa) throws IOException {

                BufferedReader fileIn = null;
                if(mapa == 1) {
                    try{
                    fileIn = new BufferedReader(new FileReader("area1.txt"));

                    String dato = fileIn.readLine();
                int cantTiles = Integer.valueOf(dato);
                dato = fileIn.readLine();
                int posX = Integer.valueOf(dato);
                int posY = Integer.valueOf(dato);
                dato = fileIn.readLine();
                int contadorX = 0;
                int contadorY = 0;
                int limiteContador =Integer.valueOf(dato);
                int tipoTile = 1;
                Image tileImg = null;
        //arreglo que contiene todo los bloques que constituyen el mapa
        while(cantTiles > 0 && tipoTile != -1) {
            cantTiles--;
            Terrain tile = null;
            tipoTile = fileIn.read();
            if(tipoTile != 10) {
            if(tipoTile == 1+ 48){
                urlG = this.getClass().getResource("silla abajo.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);

            }
            else if(tipoTile == 2+48){
                urlG = this.getClass().getResource("Azulejo.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 3+48){
                urlG = this.getClass().getResource("ExtraLab 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 4+48){
                urlG = this.getClass().getResource("ExtraLab 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 5+48){
                urlG = this.getClass().getResource("ExtraLab 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 6+48){
                urlG = this.getClass().getResource("ExtraLab 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 7+48){
                urlG = this.getClass().getResource("Mesa 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 8+48){
                urlG = this.getClass().getResource("Mesa 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 9+48){
                urlG = this.getClass().getResource("Pared 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 1+96){
                urlG = this.getClass().getResource("Pared 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 2+96){
                urlG = this.getClass().getResource("Pared 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 3+96){
                urlG = this.getClass().getResource("Pared 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 4+96){
                urlG = this.getClass().getResource("Pared 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 5+96){
                urlG = this.getClass().getResource("Pared 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 6+96){
                urlG = this.getClass().getResource("Pared 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 7+96){
                urlG = this.getClass().getResource("Pared 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 8+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 9+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 10+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 11+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 12+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 13+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 14+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 15+96){
                urlG = this.getClass().
                        getResource("Piedra a Roca Gris 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 16+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 17+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 18+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 19+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 20+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 21+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 22+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 23+96){
                urlG = this.getClass().
                        getResource("Piedra a Zacate 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 24+96){
                urlG = this.getClass().
                        getResource("Piedra.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 25+96){
                urlG = this.getClass().
                        getResource("Puerta 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
             else if(tipoTile == 26+96){
                urlG = this.getClass().
                        getResource("Puerta 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
             else if(tipoTile == 1+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
             else if(tipoTile == 2+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
             else if(tipoTile == 3+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
             else if(tipoTile == 4+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 5+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 6+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 7+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 8+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Piedra 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 9+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 10+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 11+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 12+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 13+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 14+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 15+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 16+64){
                urlG = this.getClass().
                        getResource("Roca Gris a Zacate 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 17+64){
                urlG = this.getClass().
                        getResource("Roca Gris.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 18+64){
                urlG = this.getClass().
                        getResource("Zacate.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 19+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 20+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 21+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 22+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 23+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 24+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 25+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 26+64){
                urlG = this.getClass().
                        getResource("Zacate Piedra 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 1+32){
                urlG = this.getClass().
                        getResource("pared mundo 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 2+32){
                urlG = this.getClass().
                        getResource("pared mundo 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 3+32){
                urlG = this.getClass().
                        getResource("pared mundo 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 4+32){
                urlG = this.getClass().
                        getResource("pared mundo 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 5+32){
                urlG = this.getClass().
                        getResource("pared mundo 9.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 6+32){
                urlG = this.getClass().
                        getResource("pared mundo 10.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 7+32){
                urlG = this.getClass().
                        getResource("pared mundo 11.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 8+32){
                urlG = this.getClass().
                        getResource("Mesa 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 9+32){
                urlG = this.getClass().
                        getResource("pared mundo 14.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 10+32){
                urlG = this.getClass().
                        getResource("pared mundo 16.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 11+32){
                urlG = this.getClass().
                        getResource("pared mundo 18.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 12+32){
                urlG = this.getClass().
                        getResource("Puerta 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 13+32){
                urlG = this.getClass().
                        getResource("agua 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 14+32){
                urlG = this.getClass().
                        getResource("agua 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 15+32){
                urlG = this.getClass().
                        getResource("agua 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 94){
                urlG = this.getClass().
                        getResource("agua 4.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 58){
                urlG = this.getClass().
                        getResource("agua 5.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 58+1){
                urlG = this.getClass().
                        getResource("agua 6.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 58+2){
                urlG = this.getClass().
                        getResource("agua 7.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 3+58){
                urlG = this.getClass().
                        getResource("agua 8.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 4 + 58){
                urlG = this.getClass().
                        getResource("agua.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", false);
            }
            else if(tipoTile == 5 + 58){
                urlG = this.getClass().
                        getResource("Bancav2 1.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 6 + 58){
                urlG = this.getClass().
                        getResource("Bancav2 2.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 95){
                urlG = this.getClass().
                        getResource("Bancav2 3.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 123){
                urlG = this.getClass().
                        getResource("silla abajo.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 123 + 1){
                urlG = this.getClass().
                        getResource("silla derecha.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 123 + 2){
                urlG = this.getClass().
                        getResource("silla abajo.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }
            else if(tipoTile == 123 + 6){
                urlG = this.getClass().
                        getResource("silla derecha.png");
                tileImg = Toolkit.getDefaultToolkit().getImage(urlG);
                    tile = new Terrain(posX*contadorX*5, posY*contadorY*5
                    , tileImg, "Piedra", true);
            }



            if(contadorX == limiteContador-1) {
                contadorX = 0;
                contadorY++;
            }
            else{
                contadorX++;
            }
            map.add(tile);}
            else {
                cantTiles++;
            }
        }
        fileIn.close();
                    }catch(IOException e){
                        System.err.println("file not found");
                    }
                }


    }


    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    }
