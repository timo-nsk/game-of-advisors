import { Routes } from '@angular/router';
import {PersonDetailsComponent} from './dashboard/person-details/person-details.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {ThemaDetailsComponent} from './dashboard/thema-details/thema-details.component';
import {AdminComponent} from './admin-component/admin.component';
import {MatchingComponent} from './matching/matching.component';
import {BetreuerComponent} from './betreuer/betreuer.component';
import {ThemaErstellenComponent} from './betreuer/thema-erstellen/thema-erstellen.component';

export const routes: Routes = [
  {
    path: 'home',
    component: DashboardComponent
  },
  {
    path: 'matching',
    component: MatchingComponent,
  },
  {
    path: 'betreuer',
    component: BetreuerComponent,
  },
  {
    path: 'thema/erstellen',
    component: ThemaErstellenComponent,
  },
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'details/person',
    component: PersonDetailsComponent
  },
  {
    path: 'details/thema',
    component: ThemaDetailsComponent
  }
];
