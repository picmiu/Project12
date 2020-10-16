package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import ch.makery.address.view.PersonEditDialogController;
import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
//private List<Person> personDate = new ArrayList<Person>();
    public MainApp() {
		// 샘플 데이터를 추가한다
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}
    
	public ObservableList<Person> getPersonData() {
		return personData;
	}
    
	@Override
	public void start(Stage primaryStage) {
		 this.primaryStage = primaryStage;
	     this.primaryStage.setTitle("AddressApp");

	        initRootLayout();

	        showPersonOverview();
	}

	private void showPersonOverview() {
		 try {
	            // 연락처 요약을 가져온다.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
	            AnchorPane personOverview = (AnchorPane) loader.load();

	            // 연락처 요약을 상위 레이아웃 가운데로 설정한다.
	            rootLayout.setCenter(personOverview);
	            
	            // 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
	            PersonOverviewController controller = loader.getController();
	            controller.setMainApp(this);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	private void initRootLayout() {
		 try {
	            // fxml 파일에서 상위 레이아웃을 가져온다.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            // 상위 레이아웃을 포함하는 scene을 보여준다.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public boolean showPersonEditDialog(Person person) {
	    try {
	        // fxml 파일을 로드하고 나서 새로운 스테이지를 만든다.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // 다이얼로그 스테이지를 만든다.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // person을 컨트롤러에 설정한다.
	        PersonEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setPerson(person);

	        // 다이얼로그를 보여주고 사용자가 닫을 때까지 기다린다.
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false; }
	    }

	public static void main(String[] args) {
		launch(args);
	}
}
