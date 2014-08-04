/*
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.cloudera.jiragateway.GatewayConfig

class BootStrap {

    def init = { servletContext ->
      if (!GatewayConfig.count() || GatewayConfig.count() == 0) {
        GatewayConfig config = new GatewayConfig(jiraProjects: "FIRSTPROJECT,SECONDPROJECT",
                jiraHost: "https://jira.somedomain.com",
                jiraUsername: "username",
                jiraPassword: 'password')
        config.commentTemplate = '''\
Commit for this issue with hash ${commit.shortHash()} made to ${commit.branch} in ${commit.organization}/${commit.repository}
Committer is ${commit.committer}, commit details [here|${commit.repoUrl}/commit/${commit.gitHash}]
'''

        if (config.validate()) {
          config.save()
        } else {
          config.errors.allErrors.each { error ->
            println("config error: ${error}")
          }
        }
      }
    }
    def destroy = {
    }
}