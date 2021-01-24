package snake_game;
import java.util.Scanner;
import java.util.*;
public class Main {
	 static Node head=null;
	    static Node tail=null;
	    static class Node
	    {
	        int row,col;
	        char id;
	        Node next,prev;
	        Node(int r,int c,char ch)
	        {
	            row=r;
	            col=c;
	            id=ch;
	            next=null;
	        }
	    }
	    static void createLinkedList(int data,int d,char ch)
	    {
	     Node x=new Node(data,d,ch);
	     if(head==null)
	     {
	         head=x;
	         head.prev=null;
	         tail=x;
	     }
	     else
	     {
	         x.next=head;
	         head.prev=x;
	         x.prev=null;
	         head=x;
	     }

	    }
	    static void printArray(Node head,int [][]a,int m,Node tail)
	    {
	         a[head.row][head.col]=9;
	          a[tail.row][tail.col]=8;
	          
	          Node par=head.next;
	          while(par.next!=null)
	          {
	              a[par.row][par.col]=1;
	              par=par.next;
	          }
	          for(int pp=0;pp<m;pp++)
	          {
	              for(int ww=0;ww<m;ww++)
	              {
	                  System.out.print(a[pp][ww]+" ");
	                  a[pp][ww]=0;
	              }
	              System.out.println();
	          }
	      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Scanner sc=new Scanner(System.in);
        System.out.print("Please enter board size.");
        int m=sc.nextInt();
        int [][]a=new int[m][m];
        int i=0,j=0;
        for(i=0;i<m;i++)
            for(j=0;j<m;j++)
            a[i][j]=0;
        Main obj=new Main();
        obj.createLinkedList(2,5,'Y');
        obj.createLinkedList(2,4,'B');
        obj.createLinkedList(2,3,'B');
        obj.createLinkedList(2,2,'A');
     int flag=1,flagbound=1,count=2,fruitrow=0,fruitcol=0,flagfruit=0,score=0,flagclash=0;
     Node fruitchkk=head;
    int flagfchkk=0;
    while(true)
    {
    fruitrow=new Random().nextInt(m);
    fruitcol=new Random().nextInt(m);
    while(fruitchkk!=null)
    {
        if(fruitchkk.row==fruitrow && fruitchkk.col==fruitcol)
        {
            
            flagfchkk=1;
            break;
        }
        fruitchkk=fruitchkk.next;
    }
    if(flagfchkk==0)
    break;
    }
    a[fruitrow][fruitcol]=2;
    System.out.println(fruitrow+" "+fruitcol);
    printArray(head,a,m,tail);
    System.out.println("9 denotes the head of snake while 8 denotes the tail and 2 denotes fruit");
       while(flag==1){
      char move=sc.next().charAt(0);
      if(move=='a')
      {
          
           if(head.col-1==head.next.col)
          System.out.print("Not possible in this direction");
          else
          {
          if(head.col>0)
          {   
              head.id='X';
              obj.createLinkedList(head.row,head.col-1,'A');
              if(head.row==fruitrow && head.col==fruitcol)
              {   
                  flagfruit=1;
                   score++;
              }
              else
              {
                  tail.prev.id='Y';
                  tail=tail.prev;
                  tail.next=null;
              }
          }
          else{
          flagbound=0;
              break;
          }
          }
      }
      else if(move=='s')  
      {
          if(head.row+1==head.next.row)
          System.out.print("Not possible in this direction");
          else
          {
          if(head.row<m-1)
          {
              head.id='X';
              obj.createLinkedList(head.row+1,head.col,'A');
              if(head.row==fruitrow && head.col==fruitcol)
              {   
                  flagfruit=1;
                   score++;
              }
              else
              {
                  tail.prev.id='Y';
                  tail=tail.prev;
                  tail.next=null;
              }
      }
      else{
          flagbound=0;
              break;
          }
         }
      }
       else if(move=='d')
      {
          if(head.col+1==head.next.col)
          System.out.print("Not possible in this direction");
          else
          {
          if(head.col<m-1)
          {
              head.id='X';
              obj.createLinkedList(head.row,head.col+1,'A');
              if(head.row==fruitrow && head.col==fruitcol)
              {   
                  flagfruit=1;
                   score++;
              }
              else
              {
                  tail.prev.id='Y';
                  tail=tail.prev;
                  tail.next=null;
              }
          }
           else{
          flagbound=0;
              break;
          }
          }
      }
       else if(move=='w')
      {
          if(head.row-1==head.next.row)
          System.out.print("Not possible in this direction");
          else{
          if(head.row>0)
          {
              head.id='X';
              obj.createLinkedList(head.row-1,head.col,'A');
              if(head.row==fruitrow && head.col==fruitcol)
             {   
                  flagfruit=1;
                   score++;
              }
              else
              {
                  tail.prev.id='Y';
                  tail=tail.prev;
                  tail.next=null;
              }
          }
          else{
          flagbound=0;
              break;
          }
          }
      }
      else
      flag=0;
      Node checkClash=head.next;
      while(checkClash!=null)
      {
     
          if(head.row==checkClash.row && head.col==checkClash.col)
          {
              flagclash=1;
             break;
          }
          
          checkClash=checkClash.next;
      }
      if(flagclash==1)
          break;
      if(flagfruit==1)
      {
    Node fruitchk=head;
    int flagfchk=0;
    while(true)
    {
    fruitrow=new Random().nextInt(m);
    fruitcol=new Random().nextInt(m);
    while(fruitchk!=null)
    {
        if(fruitchk.row==fruitrow && fruitchk.col==fruitcol)
        {
            
            flagfchk=1;
            break;
        }
        fruitchk=fruitchk.next;
    }
    if(flagfchk==0)
    break;
    }
          a[fruitrow][fruitcol]=0;
          flagfruit=0;
          a[fruitrow][fruitcol]=2;
          System.out.println(fruitrow+" "+fruitcol);
          printArray(head,a,m,tail);
       }
       }
       if(flagbound==0)
           System.out.println("ohh Game over! you hit the wall");
        else if(flagclash==1)
          System.out.println("ohh you hit yourself");
    else{
        printArray(head,a,m,tail);
         }
         System.out.print("Your score is "+score+".");

	}

}
