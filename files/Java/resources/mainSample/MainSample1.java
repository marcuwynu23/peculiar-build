
public class Main{
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(() ->{
			var view = new com.view.View();
			var model = new com.model.Model();
			var controller = new com.controller.Controller(view,model);
			controller.start();
		});	
	}
}