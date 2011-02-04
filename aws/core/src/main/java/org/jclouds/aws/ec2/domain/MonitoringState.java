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

package org.jclouds.aws.ec2.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.aws.ec2.services.InstanceClient;
import org.jclouds.aws.ec2.services.MonitoringClient;

/**
 * 
 * State of monitoring for the instance.
 * 
 * @author Adrian Cole
 * @see InstanceClient#runInstances
 * @see MonitoringClient#monitorInstances
 * @see MonitoringClient#UnmonitorInstances
 */
public enum MonitoringState {

   PENDING, ENABLED, DISABLING, DISABLED, UNRECOGNIZED;

   public String value() {
      return name().toLowerCase();
   }

   @Override
   public String toString() {
      return value();
   }

   public static MonitoringState fromValue(String state) {
      /**
       * Eucalyptus
       */
      if ("false".endsWith(state))
         return DISABLED;
      if ("true".endsWith(state))
         return ENABLED;
      try {
         return valueOf(checkNotNull(state, "state").toUpperCase());
      } catch (IllegalArgumentException e) {
         return UNRECOGNIZED;
      }
   }
}