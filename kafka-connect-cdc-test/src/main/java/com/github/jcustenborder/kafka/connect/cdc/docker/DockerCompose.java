/**
 * Copyright © 2017 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.kafka.connect.cdc.docker;

import com.palantir.docker.compose.connection.waiting.ClusterHealthCheck;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DockerExtension.class)
public @interface DockerCompose {
  /**
   * Location of the docker-compose.yml file to use.
   *
   * @return
   */
  String dockerComposePath();

  /**
   * Root location to output the logs to.
   *
   * @return
   */
  String logPath() default "target/docker-compose";

  /**
   * Health check class used to check the health of the cluster.
   *
   * @return
   */
  Class<? extends ClusterHealthCheck> clusterHealthCheck() default NullClusterHealthCheck.class;

  /**
   * @return
   */
  int clusterHealthCheckTimeout() default 120;
}
