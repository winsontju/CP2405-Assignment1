import java.awt.Graphics;

//Parent Class for Bike, Bus, and Car

//Initialize Variable
public class Vehicle {
		int x;
		int y;
		int speed;
		int width;
		int height;
		int position=0;
		String road;
		String signal="";
		boolean current=false;
		boolean turnOne =false;
		boolean turnTwo =false;
		boolean turnThree =false;
		int in=0;
		int in1=0;
		int in3;
		boolean check=false;
		
		
		String previous;
		public Vehicle(int x,int y) {
			this.x=x;
			this.y=y;
			this.in3=0;
			if(x>=0 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
				this.road="r1";
				this.signal="s1";
			}
			else if(y>=0 & y<=55 & x==354 || x==385 & y>=0 & y<=60) {
				this.road="r2";
				this.signal="s2";
			}
			else if(y<=370 & y>=165 & x==385 ||x==354 & y<=365 & y>=150) {
				this.road="r3";
				this.signal="s3";
			}
			else if(x>=395 & x<=820 & y==135 || x>=395 & x<=820 & y==104) {
				this.road="r4";
				this.signal="s4";
			}
			else if(y<=580 & y>=445 & x==185 || x==155 & y<=580 & y>=445) {
				this.road="r5";
				this.signal="s5";
			}
			else if(y<=580 & y>=445 & x==385 || y<=580 & y>=445 & x==355 ) {
				this.road="r6";
				this.signal="s6";
			}
			else if(y<=580 & y>=445 & x==685 || y<=580 & y>=445 & x==655) {
				this.road="r7";
				this.signal="s7";
			}
			else if(x>=0 & x<=820 & y==404 || x>=0 & x<=820 & y==432 ) {
				this.road="main";
				this.signal="main";
			}
		}

		//getter function to paint, position, speed and indexing
		public void paintMe(Graphics g) {
		}
		public void setPosition(int p) {
			this.position=p;
		}
		public int getX() {
			return x;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getSpeed() {
			return speed;
		}
		
		public void setSpeed(int speed) {
			this.speed = speed;
		}
		
		public int getWidth() {
			return width;
		}
		
		public void setWidth(int width) {
			this.width = width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public void setHeight(int height) {
			this.height = height;
		}


		public void setCondition(int x, int y) {
			if(x>=-40 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
				this.road="r1";
				this.signal="s1";
				this.current=false;
				this.previous=this.road;
				if(x<-20) {
					check=true;
				}
				
			}
			else if(y>=0 & y<=55 & x==354 || x==385 & y>-30 & y<=60) {
				this.road="r2";
				this.signal="s2";
				this.current=false;
				this.previous=this.road;
				if(y<-20) {
					check=true;
				}
			}
			else if(y<=370 & y>=165 & x==385 ||x==354 & y<=355 & y>=150) {
				this.road="r3";
				this.signal="s3";
				this.current=false;
				this.previous=this.road;
			}
			else if(x>=409 & x<=820 & y==135 || x>=390 & x<=890 & y==104) {
				this.road="r4";
				this.signal="s4";
				this.current=false;
				this.previous=this.road;
				if(x>870) {
					check=true;
				}
				
			}
			else if(y<=560 & y>=465 & x==185 || x==155 & y<=560 & y>=445) {
				this.road="r5";
				this.signal="s5";
				this.current=false;
				this.previous=this.road;
			}
			else if(y<=560 & y>=465 & x==385 || y<=560 & y>=445 & x==355 ) {
				this.road="r6";
				this.signal="s6";
				this.current=false;
				this.previous=this.road;
			}
			else if(y<=560 & y>=465 & x==685 || y<=560 & y>=445 & x==655) {
				this.road="r7";
				this.signal="s7";
				this.current=false;
				this.previous=this.road;
			}
			else if(x>=0 & x<=820 & y==404 || x>=0 & x<=850 & y==432 ) {
				this.road="main";
				this.previous=this.road;
				this.signal="main";
				if(this.x>780) {
					this.check=true;
				}
			}
			else {
				this.road="in";
				if(this.in3>=3) {
					this.current=true;
				if(this.in>=3) {
					if(this.previous.equals("r1")) {
						this.y=59;
						this.x=385;
						turnTwo();
						this.turnOne =false;
						this.turnThree =false;
						this.road="r2";
						this.previous=this.road;
						in=0;
					}
					else if(this.previous.equals("r2")) {
						if(in==3 & in1==0) {
							this.turnTwo =false;
							this.turnOne =false;
							this.turnThree =false;
							this.road="in";
							turn();
							in=0;
							
						}
						if(in1==1) {
							this.y=104;
							this.x=392;
							this.road="r4";
							in1=0;
							this.previous=this.road;
						}
						in1++;
					}
					else if(this.road.equals("r3")) {
					
					}
					else if(this.road.equals("r4")) {
					}
					else if(this.previous.equals("r5")) {

						this.y=404;
						this.x=190;
						this.turnTwo =false;
						this.turnOne =false;
						this.turnThree =false;
						this.road="main";
						in=0;
						turn();
					}
					else if(this.previous.equals("r6")) {
						this.y=404;
						this.x=390;
						this.turnTwo =false;
						this.turnOne =false;
						this.turnThree =false;
						this.road="main";
						in=0;
						turn();
					}
					else if(this.previous.equals("r7")) {
						this.y=404;
						this.x=690;
						this.turnTwo =false;
						this.turnOne =false;
						this.turnThree =false;
						this.road="main";
						in=0;
						turn();
						
					}
				}
				in++;
			}
				this.in3++;}
		}
		public void turn() {
			int t=this.width;
			this. width=this.height;
			this.height=t;
		}
		
		public void turnOne() {
			if(this.turnOne ==false) {
			int t=0;
			t=this.height;
			this.height=this.width;
			this.width=t;
			this.turnOne =true;
			
			}
			else {
				int t=0;
				t=this.height;
				this.height=this.width;
				this.width=t;
				this.turnOne =false;
			}
		}
		public void turnTwo() {
			if(this.turnTwo ==false) {
			int t=0;
			t=this.height;
			this.height=this.width;
			this.width=t;
			this.turnTwo =true;
			
			}
			else {
				int t=0;
				t=this.height;
				this.height=this.width;
				this.width=t;
				this.turnTwo =false;
			}
		}
		public void turnThree() {
			if(this.turnThree ==false) {
				this.turnThree =true;
			}
			else {
				this.turnThree =false;
			}
		}
	}

