{{- define "flight-stack.name" -}}
flight-stack
{{- end }}

{{- define "flight-stack.labels" -}}
app.kubernetes.io/name: {{ include "flight-stack.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
