/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.setupwizard.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DeviceSetupUserTest {

    @Test
    fun systemUserSetsUpTheDevice() {
        assertTrue(DeviceSetupUser.isDeviceSetupUser(0, headlessSystemUserMode = false, deviceProvisioned = false))
        assertTrue(DeviceSetupUser.isDeviceSetupUser(0, headlessSystemUserMode = false, deviceProvisioned = true))
    }

    @Test
    fun secondaryUserGetsTheUserSetup() {
        assertFalse(DeviceSetupUser.isDeviceSetupUser(10, headlessSystemUserMode = false, deviceProvisioned = false))
        assertFalse(DeviceSetupUser.isDeviceSetupUser(10, headlessSystemUserMode = false, deviceProvisioned = true))
    }

    @Test
    fun firstUserOfAHeadlessSystemUserDeviceSetsUpTheDevice() {
        assertTrue(DeviceSetupUser.isDeviceSetupUser(10, headlessSystemUserMode = true, deviceProvisioned = false))
    }

    @Test
    fun usersAddedLaterOnAHeadlessSystemUserDeviceGetTheUserSetup() {
        assertFalse(DeviceSetupUser.isDeviceSetupUser(11, headlessSystemUserMode = true, deviceProvisioned = true))
    }
}
