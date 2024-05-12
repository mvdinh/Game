package Frame;

import javax.swing.JFrame;

import Panel.Load;

public class LoadFrame extends JFrame {
	Load loading;
	LoadFrame(){
		loading = new Load();
		add(loading);
		setBounds(420, 100, 500, 350);
		setSize(650,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		LoadFrame l= new LoadFrame();
	}
}
