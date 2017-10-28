

package pixel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import javax.imageio.ImageIO;

public class Pixel {
   BufferedImage image,image1;
   int width,width1,i,j;
   int height,height1;
   
   
     
         BufferedImage mani = new BufferedImage(259,194,BufferedImage.TYPE_INT_RGB );
   public static Image getImageFromArray(int[] pixels, int width, int height) {
            BufferedImage imag = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            WritableRaster raster = (WritableRaster) imag.getData();
            raster.setPixels(0,0,width,height,pixels);
            return imag;
        }
   public Pixel() {
      try{
         File input = new File("C:\\Users\\Vishveshwara\\Desktop\\test.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         File in= new File("C:\\Users\\Vishveshwara\\Desktop\\me.jpg"); 
         image1=ImageIO.read(in); 
          
          width1 = image1.getWidth();
         height1 = image1.getHeight();
         
         int count = 0;
         Color c[][];
         c = new Color[height][width];
         int x=width*height; 
         int d[][];
         d = new int [height][width];         
         Color c1[][];
         c1 = new Color[height1][width1];
         int x1=width1*height1; 
        
         
         for( i=0; i<height; i++)
         {
         
            for( j=0; j<width; j++){
            
               count++;
               c[i][j] = new Color(image.getRGB(j, i));
               //System.out.println("S.No: " + count + " Red: " + c[i][j].getRed() +"  Green: " + c[i][j].getGreen() + " Blue: " + c[i][j].getBlue());
              // pix[i][j]={c.getRed(),c.getGreen(),c.getBlue()};
               
            }
         }
         
       for(i=0; i<height1; i++)
       {
            System.out.println("\n");
            for(j=0; j<width1; j++)
            {
                 
               c1[i][j] = new Color(image1.getRGB(j, i));
        //System.out.println(c1[i][j].getRed()+"  "+c1[i][j].getGreen()+"  "+c1[i][j].getBlue()+"  ");
  
            }
       }
        
         
        int col[];
        col=new int[height*width];
        int z=0;
         for(i=0; i<height1; i++){
        
            for(j=0; j<width1; j++){
                int y=new Color(255,255,255).getRGB();
                int r=(c[i][j].getRed()+c1[i][j].getRed())%255;
                int g=(c[i][j].getGreen()+c1[i][j].getGreen())%255;
                int b=(c[i][j].getBlue()+c1[i][j].getBlue())%255;
                int rgb=new Color(r,g,b).getRGB();
                col[z++]=rgb;
                int abc = (r << 16) | (g << 8) | b;
              //  int =new Color((c[i][j].getRed()+c1[i][j].getRed())%255,(c[i][j].getGreen()+c1[i][j].getGreen())%255,(c[i][j].getBlue()+c1[i][j].getBlue())%255).getRGB;
               // System.out.println((c[i][j].getRed()+c1[i][j].getRed())%255+" "+(c[i][j].getGreen()+c1[i][j].getGreen())%255+" "+(c[i][j].getBlue()+c1[i][j].getBlue())%255);
                mani.setRGB(j,i,abc);
                       }}
         mani=(BufferedImage) getImageFromArray(col, width, height);// 
      }
     catch(Exception E)
     {}        
    try{
        File f;

      f = new File("C:\\Users\\Vishveshwara\\Desktop\\final.jpg");
      ImageIO.write(mani, "jpg", f);
      
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
   }
   static public void main(String args[]) throws Exception 
   {
      Pixel obj = new Pixel();
   }
}

    
