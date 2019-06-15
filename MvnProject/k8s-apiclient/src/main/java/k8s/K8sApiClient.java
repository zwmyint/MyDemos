package k8s;

import java.io.File;
import java.io.FileReader;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.KubeConfig;

public class K8sApiClient {

  public static void main(String[] args) {
    try {
      FileReader yamlFile = new FileReader(new File("." + File.separator + "config.yaml"));
      KubeConfig kubeConfig = KubeConfig.loadKubeConfig(yamlFile);
      ApiClient client = Config.fromConfig(kubeConfig);
      Configuration.setDefaultApiClient(client);
      CoreV1Api api = new CoreV1Api();
      V1PodList list = api
          .listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
      for (V1Pod item : list.getItems()) {
        System.out.println(item.getMetadata().getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
