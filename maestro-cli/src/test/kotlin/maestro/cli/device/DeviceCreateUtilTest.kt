package maestro.cli.device

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class DeviceCreateUtilTest {

    @Test
    fun `deviceNameForShard keeps non-sharded device name unchanged`() {
        val deviceName = DeviceCreateUtil.deviceNameForShard(
            deviceName = "Maestro_ANDROID_pixel_6_android-34",
            shardIndex = null,
        )

        assertThat(deviceName).isEqualTo("Maestro_ANDROID_pixel_6_android-34")
    }

    @Test
    fun `deviceNameForShard appends one-based shard suffix`() {
        val firstDeviceName = DeviceCreateUtil.deviceNameForShard(
            deviceName = "Maestro_ANDROID_pixel_6_android-34",
            shardIndex = 0,
        )
        val thirdDeviceName = DeviceCreateUtil.deviceNameForShard(
            deviceName = "Maestro_ANDROID_pixel_6_android-34",
            shardIndex = 2,
        )

        assertThat(firstDeviceName).isEqualTo("Maestro_ANDROID_pixel_6_android-34_1")
        assertThat(thirdDeviceName).isEqualTo("Maestro_ANDROID_pixel_6_android-34_3")
    }
}
