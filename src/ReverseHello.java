class HELLOWORLD extends Thread{
int num;
HELLOWORLD(int num){
this.num=num;
}
public void run(){
	
System.out.println("Hi! I am Thread"+" "+num+"!");
}
}
public class ReverseHello{
public static void main(String[] args){
HELLOWORLD[] t=new HELLOWORLD[20];
for(int i=0;i<20;i++){
   t[i]=new HELLOWORLD(20-i);
}
for(int i=0; i<20;i++){
   t[i].start();
try{
  t[i].join();
}
catch(InterruptedException e){
	System.out.println(e);
}
}
}
}