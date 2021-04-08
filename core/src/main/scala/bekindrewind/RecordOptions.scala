package bekindrewind

final case class RecordOptions(
  shouldRecord: VcrRecordRequest => Boolean,
  notRecordedThrowsErrors: Boolean,
  overwriteAll: Boolean,
  requestTransformer: RequestTransformer,
  responseTransformer: ResponseTransformer
) {
  def shouldRecord(shouldRecord: VcrRecordRequest => Boolean): RecordOptions =
    copy(shouldRecord = shouldRecord)

  def notRecordedThrowsErrors(notRecordedThrowsErrors: Boolean): RecordOptions =
    copy(notRecordedThrowsErrors = notRecordedThrowsErrors)

  def overwriteAll(overwriteAll: Boolean): RecordOptions =
    copy(overwriteAll = overwriteAll)
}

object RecordOptions {
  val default: RecordOptions = RecordOptions(
    _ => true,
    notRecordedThrowsErrors = false,
    overwriteAll = false,
    requestTransformer = RequestTransformer.noop,
    responseTransformer = ResponseTransformer.noop
  )

  val off: RecordOptions = RecordOptions(
    _ => false,
    notRecordedThrowsErrors = false,
    overwriteAll = false,
    requestTransformer = RequestTransformer.noop,
    responseTransformer = ResponseTransformer.noop
  )
}
