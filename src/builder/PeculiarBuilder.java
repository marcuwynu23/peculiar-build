package builder; 


public class PeculiarBuilder{
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(() ->{
			new view.View().showApp();
		});	
	}
} 