package br.cefetmg.games.collision;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Utilitário para verificação de colisão.
 *
 * @author fegemo <coutinho@decom.cefetmg.br>
 */
public class Collision {

    /**
     * Verifica se dois círculos em 2D estão colidindo.
     * @param c1 círculo 1
     * @param c2 círculo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean circlesOverlap(Circle c1, Circle c2) {
        Vector2 v1 = new Vector2(c1.x, c1.y);
        Vector2 v2 = new Vector2(c2.x, c2.y);
        
        float distancia = v1.dst2(v2);
        
        
        return ((c1.radius+c2.radius)*(c1.radius+c2.radius)) >= distancia;
    }

    /**
     * Verifica se dois retângulos em 2D estão colidindo.
     * Esta função pode verificar se o eixo X dos dois objetos está colidindo
     * e então se o mesmo ocorre com o eixo Y.
     * @param r1 retângulo 1
     * @param r2 retângulo 2
     * @return true se há colisão ou false, do contrário.
     */
    public static final boolean rectsOverlap(Rectangle r1, Rectangle r2) {
        Vector2 v1 = new Vector2(r1.x, r1.y);
        Vector2 v2 = new Vector2(r2.x, r2.y);
        
        boolean colisaoX = v1.x+r1.width >= v2.x && v2.x+r2.width >= v1.x;
        boolean colisaoY = v1.y+r1.height >= v2.y && v2.y+r2.height >= v1.y;
        
        return colisaoX && colisaoY;
    }
    
    
    public static final boolean rectsCircleOverLap(Circle c1, Rectangle r1){
        Vector2 v1 = new Vector2(r1.x, r1.y);
        Vector2 v2 = new Vector2(c1.x, c1.y);
        Vector2 center = r1.getCenter(v1);
        
	if((v2.x - center.x) < 0){
            center.set(center.x-(r1.width/2), center.y);
        }else if((v2.x - center.x) > 0){
            center.set(center.x+(r1.width/2), center.y);
	}
	
	if((v2.y - center.y) < 0){
            center.set(center.x, center.y-(r1.height/2));
	}else if((v2.y - center.y) > 0){
            center.set(center.x, center.y+(r1.height/2));
	}
		
        float distancia = center.dst2(v2);

        
        return distancia < (c1.radius*c1.radius);
    }
        
        
}
