package Curso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ler {

    public static int umInt()
    {
        while(true)
        {
            try
            {
                return Integer.valueOf(umString().trim()).intValue();
            }
            catch(Exception e)
            {
                System.out.println("Não é um inteiro ");
            }
        }
    }


    public static double umDouble()
    {
        while(true)
        {
            try
            {
                return Double.valueOf(umString().trim()).doubleValue();
            }
            catch(Exception e)
            {
                System.out.println("Não é um double ");
            }
        }
    }


        public static float umFloat()
        {
            while(true)
            {
                try
                {
                    return Float.valueOf(umString().trim()).floatValue();
                }
                catch(Exception e)
                {
                    System.out.println("Não é um flota ");
                }
            }
        }



    public static String umString()
    {
        String s = "";

        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
            s = in.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Erro lendo o input.");
        }

        return s;
    }


    public static char umChar()
    {
        char s =' ';

        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
            s = (char)in.read();
        }
        catch (IOException e)
        {
            System.out.println("Erro lendo o input.");
        }

        return s;
    }


}
