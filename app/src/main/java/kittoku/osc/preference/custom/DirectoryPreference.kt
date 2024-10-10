package kittoku.osc.preference.custom

import android.content.Context
import android.util.AttributeSet
import androidx.preference.Preference
import kittoku.osc.R
import kittoku.osc.preference.OscPrefKey
import kittoku.osc.preference.accessor.getURIPrefValue


internal abstract class DirectoryPreference(context: Context, attrs: AttributeSet) : Preference(context, attrs), OscPreference {
    override fun updateView() {
        summary = getURIPrefValue(oscPrefKey, sharedPreferences!!)?.path ?: context.getString(R.string.directory_no_selection)
    }

    override fun onAttached() {
        initialize()
    }
}

internal class SSLCertDirPreference(context: Context, attrs: AttributeSet) : DirectoryPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.SSL_CERT_DIR
    override val preferenceTitle = context.getString(R.string.directory_select_trusted_certificates)
    override val parentKey = OscPrefKey.SSL_DO_SPECIFY_CERT
}

internal class LogDirPreference(context: Context, attrs: AttributeSet) : DirectoryPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.LOG_DIR
    override val preferenceTitle = context.getString(R.string.directory_select_logs)
    override val parentKey = OscPrefKey.LOG_DO_SAVE_LOG
}
