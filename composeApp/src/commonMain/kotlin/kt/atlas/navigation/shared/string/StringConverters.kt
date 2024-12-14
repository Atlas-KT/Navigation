package kt.atlas.navigation.shared.string

import kotlin.reflect.KClass

object StringConverters {
    class Class(private val form: RemappingForm = RemappingForm.Identity) : StringConverter<KClass<*>> {
        override fun remap(source: KClass<*>): String = when (form) {
            RemappingForm.Identity -> remapIdentity(source)
            RemappingForm.Name -> remapName(source)
        }

        private fun remapIdentity(source: KClass<*>): String =
            remapName(source)
                .replace(" ", "")
                .replace("-", "")
                .replace("$", "")

        private fun remapName(source: KClass<*>): String =
            (source.simpleName ?: "Unknown")
                .replaceFirstChar { it.uppercaseChar() }

        enum class RemappingForm {
            Identity, Name
        }
    }
}