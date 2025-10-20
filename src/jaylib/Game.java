package jaylib;
import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

public class Game {
	public static void main(String[] args) {
		String appHomeDir = System.getenv("APP_HOME");
		System.out.println(appHomeDir);
		InitWindow(1280, 720, "Demo");
		SetTargetFPS(60);
		boolean Static = false;
		float SphereSize = 5.0f;
		int SphereCount = 1;
		float variance = 0.5f;
		float max = variance * 1.0f;
		float min = variance * 1.0f * -1.0f;
		float testY = (float)(Math.random() * (max - min) + min);
		float testX = (float)(Math.random() * (max - min) + min);
		float testZ = (float)(Math.random() * (max - min) + min);
		int i;
		Camera3D camera = new Camera3D()._position(new Vector3().x(18).y(16).z(18))
				.target(new Vector3())
				.up(new Vector3().x(0).y(1).z(0))
				.fovy(45).projection(CAMERA_PERSPECTIVE);

		while (!WindowShouldClose()) {
			if (IsKeyPressed('P')) Static = !Static; //PauseJitter
			if (IsKeyPressed('R')) {
				variance = 0.5f;
				SphereCount = 1;
			}
			if (IsKeyPressed('L')) SphereCount *= 2;
			if (IsKeyDown('=')) variance += 0.05f;
			if (IsKeyDown('-')) variance -= 0.05f;
			max = variance * 1.0f;
			min = -variance * 1.0f;
			if (IsKeyDown(KEY_Q)) SphereSize += 0.1f;
			if (IsKeyDown(KEY_E)) SphereSize -= 0.1f;
			UpdateCamera(camera, CAMERA_ORBITAL);
			BeginDrawing();
			ClearBackground(RAYWHITE);
			BeginMode3D(camera);
			DrawGrid(20, 1.0f);
			if (!Static) {
				testY = (float)(Math.random() * (max - min) + min);
				testZ = (float)(Math.random() * (max - min) + min);
				testX = (float)(Math.random() * (max - min) + min);
			
			for (i = 0; i < SphereCount; i++){
				if (i == 0) DrawSphere(new Vector3().x(testX).y(testY).z(testZ), SphereSize, BLUE);
				else DrawSphere(new Vector3().x((float)(Math.random() * (max - min) + min)).y((float)(Math.random() * (max - min) + min)).z((float)(Math.random() * (max - min) + min)), SphereSize, RED);
				}
			}
			EndMode3D();
			DrawText("Hello world", 40, 40, 10, VIOLET);
			DrawText("Static : "+String.valueOf(Static),20,50,20,RED);
			DrawText("Variance : "+String.valueOf(variance),20,80,20,GREEN);
			DrawText("Min|Max :"+String.valueOf(min)+" | " +String.valueOf(max),20,100,20,PURPLE);
			DrawText("Sphere Size : "+String.valueOf(SphereSize),20,120,20,BEIGE);
			DrawText("Sphere Count : "+String.valueOf(SphereCount),20,140,20,BROWN);
			DrawText("PRESS R TO RESET",20,200,40,RED);
			DrawFPS(20, 20);
			EndDrawing();
	        }
	        CloseWindow();
	}
}
