/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_norma;

import javax.swing.JOptionPane;

/**
 *
 * @author cc1305794
 */
public class Maquina_Norma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String msg ="";        
        
        msg += " Divisao: 1500/3 = " + divisao(1500, 3, 0, 0);
        msg += "\n Divisao: 150/2 = " + divisao(150, 2, 0, 0);
        msg += "\n RDivisao: 7%5 = " + restoDivisao(7, 5, 0, 0);
        msg += "\n RDivisao: 13%2 = " + restoDivisao(13, 2, 0, 0);
        msg += "\n Atribuição: " + atribuicao(3, 5);
        msg += "\n Mult: 3*5 = " + Multplicacao(3, 5);
        msg += "\n Mult: 7*10 = " + Multplicacao(7, 10);
        msg += "\n primo: 800 e primo.  " + primo(800);
        msg += "\n primo: 883 e primo. " + primo(883);
        msg += "\n primo: 1983 e primo. " + primo(1693);
        msg += "\n Fatorial: fatorial de 0 = " + fatorial(0);
        msg += "\n Fatorial: fatorial de 1 = " + fatorial(1);
        msg += "\n Fatorial: fatorial de 5 = " + fatorial(5);
        msg += "\n Fatorial: fatorial de 10 = " + fatorial(10);
        msg += "\n Exponencial: 2^0 = " + exponencial(2, 0);
        msg += "\n Exponencial: 2^1 = " + exponencial(2, 1);
        msg += "\n Exponencial: 2^10 = " + exponencial(2, 10);
        msg += "\n Exponencial: 10^2 = " + exponencial(10, 2);
        
        System.out.println(msg);
        JOptionPane.showMessageDialog(null, msg);
        
    }

    public static int zerar(int A) {
        while (diferenteDeZero(A)) {
            A = A - 1;
        }
        return A;
    }

    public static int soma(int A, int B) {
        while (diferenteDeZero(B)) {
            A = A + 1;
            B = B - 1;
        }
        return A;
    }

    public static int soma(int A, int B, int C) {
        while (diferenteDeZero(B)) {
            A = A + 1;
            B = B - 1;
            C = C + 1;
        }
        while (diferenteDeZero(C)) {
            B = B + 1;
            C = C - 1;
        }
        return A;
    }

    public static int atribuicao(int A, int B) {
        while (A != 0) {
            A = A - 1;
            B = B + 1;
        }
        return B;
    }

    public static int Multplicacao(int A, int B) {
        int C = 0;
        int D = 0;
        //System.out.println(A + " " + B);
        while (diferenteDeZero(A)) {
            C = C + 1;
            A = A - 1;
        }
        while (diferenteDeZero(C)) {
            A = soma(A, B, 0);
            C = C - 1;
        }
        return A;
    }

    public static boolean diferenteDeZero(int A) {
        if (A == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int subtracao(int A, int B) {
        while (diferenteDeZero(B)) {
            if (A == 0) {
                return 0;
            }
            A = A - 1;
            B = B - 1;
        }
        return A;
    }

    public static boolean AmenorB(int A, int B) {
        while (diferenteDeZero(B)) {
            if (A == 0) {
                if (B == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            A = A - 1;
            B = B - 1;
        }
        return false;
    }

    public static boolean primo(int A) {
        int B = 0;
        int C = 0;
        //verifica se  é o 2 (ja é primo)
        if (subtracao(A, 2) == 0) {
            return true;
        } else //verifica se o numero é par 
        if (restoDivisao(A, 2, 0, 0) == 0) {
            return false;
        } else {
            B = atribuicao(B, divisao(A, 2, 0, 0));
            while (diferenteDeZero(B)) {
                if (restoDivisao(A, B, 0, 0) == 0) {
                    return false;
                }
                if (subtracao(B, 2) == 0) {
                    return true;
                }
                B = B - 1;
            }
            return true;
        }
    }

    public static int restoDivisao(int A, int B, int C, int D) {
        D = zerar(D);
        if (B == 0) {
            return 0;
        }
        while (diferenteDeZero(A)) {
            while (diferenteDeZero(B)) {
                if (AmenorB(A, B)) {
                    return A;
                }
                A = A - 1;
                B = B - 1;
                C = C + 1;
            }
            B = atribuicao(C, B);
            C = zerar(C);
            D = D + 1;
        }
        return A;
    }

    public static int divisao(int A, int B, int C, int D) {
        D = zerar(D);
        if (B == 0) {
            return 0;
        }
        while (diferenteDeZero(A)) {
            while (diferenteDeZero(B)) {
                if (A == 0) {
                    return D;
                }
                A = A - 1;
                B = B - 1;
                C = C + 1;
            }
            B = atribuicao(C, B);
            C = zerar(C);
            D = D + 1;
        }
        return D;
    }

    public static int fatorial(int A) {
        int B = 1;
        int C = 0;
        if (A == 0) {
            return 1;
        }
        A = A - 1;
        if (A == 0) {
            return 1;
        }
        while (diferenteDeZero(A)) {
            C = C + 1;
            B = soma(Multplicacao(B, C), B);
            A = A - 1;
        }
        return B;
    }

    public static int exponencial(int A, int B) {
        int C=0;
        C = atribuicao(C, A);        
        if (B == 0) {
            return 1;
        }
        B = B - 1;
        if (B == 0) {
            return A;
        }        
        while (diferenteDeZero(B)) {
            A = Multplicacao(A, C);
            B = B - 1;
        }
        return A;
    }
}
