/*
 * Copyright 2013 Stefan Domnanovits
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codebullets.sagalib.processing;

import com.codebullets.sagalib.Saga;
import javax.inject.Provider;

/**
 * When asked returns a provider capable of create a new saga instance.
 */
@FunctionalInterface
public interface SagaProviderFactory {
    /**
     * Creates a new provider capable of creating a new instance of the class
     * specified in the parameter.
     * @return returns a <b>non-null</b> instance that creates new instances of sagas.
     */
    <T extends Saga> Provider<T> createProvider(Class<T> sagaClass);
}
