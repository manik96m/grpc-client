import com.demoApp.grpc.User;
import com.demoApp.grpc.userGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        User.APIResponse apiResponse = userStub.login(User.LoginRequest.newBuilder().setUsername("manik").setPassword("mahajan").build());
        System.out.println("API Response -> " + apiResponse.getResponseMessage());
    }
}
