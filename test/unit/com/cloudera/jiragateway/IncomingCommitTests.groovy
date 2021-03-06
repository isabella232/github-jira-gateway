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



package com.cloudera.jiragateway



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(IncomingCommit)
class IncomingCommitTests {

  void testConstraints() {
    mockForConstraintsTests(IncomingCommit)

    def commit = new IncomingCommit()

    assertFalse(commit.validate())
    assertEquals("nullable", commit.errors["gitHash"])
    assertEquals("nullable", commit.errors["timestamp"])
    assertEquals("nullable", commit.errors["author"])
    assertEquals("nullable", commit.errors["committer"])
    assertEquals("nullable", commit.errors["branch"])
    assertEquals("nullable", commit.errors["repository"])
    assertEquals("nullable", commit.errors["organization"])
    assertEquals("nullable", commit.errors["repoUrl"])

    assertNull(commit.errors["message"])
    assertNull(commit.errors["jiras"])
  }
}
