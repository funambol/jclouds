/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.rackspace.cloudservers.domain;

public class ShareIp {

   private boolean configureServer;
   private int sharedIpGroupId;

   public void setConfigureServer(boolean configureServer) {
      this.configureServer = configureServer;
   }

   public boolean isConfigureServer() {
      return configureServer;
   }

   public void setSharedIpGroupId(int sharedIpGroupId) {
      this.sharedIpGroupId = sharedIpGroupId;
   }

   public int getSharedIpGroupId() {
      return sharedIpGroupId;
   }

}