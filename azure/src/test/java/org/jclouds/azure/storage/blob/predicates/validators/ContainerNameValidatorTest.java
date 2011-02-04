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

package org.jclouds.azure.storage.blob.predicates.validators;

import org.testng.annotations.Test;
import org.jclouds.azure.storage.blob.predicates.validators.ContainerNameValidator;

public class ContainerNameValidatorTest {

    @Test
    public void testNamesValidity() {
        ContainerNameValidator validator = new ContainerNameValidator();

        validator.validate("adasd");

        validator.validate("adasd-ab");

        validator.validate("zzz");
        validator.validate("abcefghjlkmnop");

    }

    @Test
    public void testInvalidNames() {

        ContainerNameValidator validator = new ContainerNameValidator();

        try {
            //double dash - should fail
            validator.validate("adasd-ab--baba");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

        try {
            // dots - should fail
            validator.validate("abc.zz.la");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

        try {
            // uppercase - should fail
            validator.validate("abcZZla");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

        try {
            validator.validate("zz");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

        try {
            // non-ASCII - should fail
            validator.validate("a????");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

        try {
            // starts with dash - should fail
            validator.validate("-adasd");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

        try {
            // ends with dash - should fail
            validator.validate("adasd-");
            throw new RuntimeException("to be converted to TestException later");
        } catch(IllegalArgumentException e) {
            // supposed to happen - continue
        }

    }

}