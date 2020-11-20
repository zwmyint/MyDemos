import PySimpleGUI as sg
from fileutil import read
from fileutil import appendCopyrightHeader
from fileutil import getSourceFiles

supportedLanguages = ['Java', 'Javascript', 'Shell', 'Xml']

def initUI():
  layout = [
    [sg.Text('Apply to', size=(8, 1)), sg.Input(size=(65, 1), key="source"), sg.FolderBrowse()],
    [sg.Text('Formatting', size=(8, 1)), 
    sg.Listbox(values=supportedLanguages, size=(63, 3), key='language', enable_events=True), 
    sg.Button('Apply  ', key='apply')],
    [sg.Text('Copyright Content', size=(60, 1))],
    [sg.Multiline(size=(82, 15), key='content')],
    [sg.Text('', size=(60, 2), key='message')],
    [sg.ProgressBar(100, orientation='h', size=(44, 3), key='progressbar')]
  ]
  window = sg.Window('Copyright-Header Tool', layout, no_titlebar=False, finalize=True)
  handleWidgetEvents(window)


def formattingListboxListener(window, values):
    if values['language'][0] == "Java":
      window['content'].update(read('./copyrights/java-template'))
    if values['language'][0] == "Javascript":
      window['content'].update(read('./copyrights/js-template'))
    if values['language'][0] == "Shell":
      window['content'].update(read('./copyrights/shell-template'))
    if values['language'][0] == "Xml":
      window['content'].update(read('./copyrights/xml-template'))

def applyBtnListener(window, values):
  appendCopyrightHeader(window, getSourceFiles(values['source']), values['content'])

def setDefaultLanguage(window):
  window['language'].SetValue('Java')
  window['content'].update(read('./copyrights/java-template'))

def handleWidgetEvents(window):
  setDefaultLanguage(window)
  while True:
    event, values = window.read()
    if event == 'apply':
      applyBtnListener(window, values)
    if event == 'language':
      formattingListboxListener(window, values)
    if event in (sg.WIN_CLOSED, 'Exit'):
        break
  window.close()
