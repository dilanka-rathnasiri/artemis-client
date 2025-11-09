import { Component, signal } from '@angular/core';
import { SendView } from './send-view/send-view';
import { ReceiveView } from './receive-view/receive-view';

@Component({
  selector: 'app-root',
  imports: [SendView, ReceiveView],
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App {
  protected readonly title = signal('artemis-client');
}
