import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.utils.KubernetesSerialization;
import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyTest {
    @Inject
    private KubernetesClient kubernetesClient;
    
    @Test
    public void test() {
        var dummyPod = """
---
apiVersion: v1
kind: Pod
metadata:
    name: example
    namespace: example-namespace
spec:
    containers:
        - image: dummy""";

        this.kubernetesClient.getKubernetesSerialization().unmarshal(dummyPod);
    }
}
